package cn.plusman.mybatis.plugin;

import cn.plusman.mybatis.plugin.pagedir.IPage;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


/**
 * @author plusman
 * @since 2021/3/14 11:35 PM
 */
@Intercepts({
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class PageInterceptor implements Interceptor {
    private HashMap<String, MappedStatement> msCountMapCache = new HashMap<>();
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        ResultHandler resultHandler = (ResultHandler) args[3];
        Executor executor = (Executor) invocation.getTarget();
        
        CacheKey cacheKey;
        BoundSql boundSql;
        //由于逻辑关系，只会进入一次
        if (args.length == 4) {
            //4 个参数时
            boundSql = ms.getBoundSql(parameter);
            cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
        } else {
            //6 个参数时
            cacheKey = (CacheKey) args[4];
            boundSql = (BoundSql) args[5];
        }
        
        // 获取 Page 对象
        IPage page = (IPage) (((MapperMethod.ParamMap) parameter).get("page"));
        
        // 生成 countMS
        MappedStatement countMS = buildCountMappedStatement(ms);
        
        // 生成 countKey
        CacheKey countKey = executor.createCacheKey(countMS, parameter, RowBounds.DEFAULT, boundSql);
        
        // 生成 countSql
        BoundSql countBoundSql = new BoundSql(
            countMS.getConfiguration(),
            generateCountSql(boundSql),
            boundSql.getParameterMappings(),
            parameter
        );
    
        // 统计 count 计算
        Object countResultList = executor.query(countMS, parameter, RowBounds.DEFAULT, resultHandler, countKey, countBoundSql);
        Long count = (Long) ((List) countResultList).get(0);
        
        // 查询数据列表
        BoundSql pageBoundSql = new BoundSql(
            ms.getConfiguration(),
            generatePageSql(page, boundSql),
            boundSql.getParameterMappings(),
            parameter
        );
        
        List rtnList = executor.query(ms, parameter, RowBounds.DEFAULT, resultHandler, cacheKey, pageBoundSql);
        
        page.setTotal(count);
        page.setRecords(rtnList);
        
        return rtnList;
        // return invocation.proceed();
    }
    
    
    /**
     * 生成 pageSql
     * @param boundSql
     * @return
     */
    private String generatePageSql(IPage page, BoundSql boundSql) {
        // 进行分页查询
        String pageSql = String.format(
            "%s limit %s, %s",
            boundSql.getSql(),
            page.offset(),
            page.getSize()
        );
        
        return pageSql;
    }
    
    /**
     * 生成 count 语句
     * @return
     */
    private String generateCountSql(BoundSql boundSql) throws JSQLParserException {
        // 生成 count sql
        Statement stmt = CCJSqlParserUtil.parse(boundSql.getSql());
        Select select = (Select) stmt;
        SelectBody selectBody = select.getSelectBody();
        
        List<SelectItem> COUNT_ITEM = new ArrayList<>();
        COUNT_ITEM.add(new SelectExpressionItem(new Column("count(0)")));
        
        ((PlainSelect) selectBody).setSelectItems(COUNT_ITEM);
        
        return select.toString();
    }
    
    /**
     *
     * @return
     */
    private MappedStatement buildCountMappedStatement(MappedStatement ms) {
        String countMsId = ms.getId() + "_COUNT";
        MappedStatement countMs = msCountMapCache.get(countMsId);
        
        if (countMs == null) {
            MappedStatement.Builder builder = new MappedStatement.Builder(
                ms.getConfiguration(),
                countMsId,
                ms.getSqlSource(),
                ms.getSqlCommandType()
            )
                .resource(ms.getResource())
                .fetchSize(ms.getFetchSize())
                .statementType(ms.getStatementType())
                .keyGenerator(ms.getKeyGenerator());
    
            if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
                StringBuilder keyProperties = new StringBuilder();
                for (String keyProperty : ms.getKeyProperties()) {
                    keyProperties.append(keyProperty).append(",");
                }
                keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
                builder.keyProperty(keyProperties.toString());
            }
    
            builder.timeout(ms.getTimeout());
            builder.parameterMap(ms.getParameterMap());
    
            List<ResultMap> resultMaps = new ArrayList<>();
            
            ResultMap resultMap = new ResultMap.Builder(
                ms.getConfiguration(),
                ms.getId(),
                Long.class,
                new ArrayList<ResultMapping>()
            ).build();
            resultMaps.add(resultMap);
            
            builder.resultMaps(resultMaps);
            builder.resultSetType(ms.getResultSetType());
            builder.cache(ms.getCache());
            builder.flushCacheRequired(ms.isFlushCacheRequired());
            builder.useCache(ms.isUseCache());
            
            return builder.build();
        }
        
        return countMs;
    }
    
    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
    }
}
