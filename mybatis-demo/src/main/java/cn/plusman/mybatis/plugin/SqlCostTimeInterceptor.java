package cn.plusman.mybatis.plugin;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * cn.plusman.mybatis.plugin
 *
 * @author plusman
 * @since 12/17/20
 */
@Intercepts({
    @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
    @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
    @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})
})
public class SqlCostTimeInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
       Object target = invocation.getTarget();
       long startTime = System.currentTimeMillis();
       StatementHandler statementHandler = (StatementHandler) target;
       try {
           return invocation.proceed();
       } finally {
           long costTime = System.currentTimeMillis() - startTime;
           BoundSql boundSql = statementHandler.getBoundSql();
           String sql = boundSql.getSql();
           System.out.println(String.format("执行 SQL：[ %s ]执行耗时[ %s ms]", sql, costTime));
       }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息：" + properties);
    }
}
