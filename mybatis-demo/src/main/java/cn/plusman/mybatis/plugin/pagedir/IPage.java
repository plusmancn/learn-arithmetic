package cn.plusman.mybatis.plugin.pagedir;

import java.io.Serializable;
import java.util.List;

/**
 * @author plusman
 * @since 2021/3/21 11:05 PM
 */
public interface IPage <T> extends Serializable {
    /**
     * 计算当前分页偏移量
     */
    default long offset() {
        long current = getCurrent();
        if (current <= 1L) {
            return 0L;
        }
        return (current - 1) * getSize();
    }
    
    /**
     * 当前分页总页数
     */
    default long getPages() {
        if (getSize() == 0) {
            return 0L;
        }
        long pages = getTotal() / getSize();
        if (getTotal() % getSize() != 0) {
            pages++;
        }
        return pages;
    }
    
    /**
     * 分页记录列表
     *
     * @return 分页对象记录列表
     */
    List<T> getRecords();
    
    /**
     * 设置分页记录列表
     */
    IPage<T> setRecords(List<T> records);
    
    /**
     * 当前满足条件总行数
     *
     * @return 总条数
     */
    long getTotal();
    
    /**
     * 设置当前满足条件总行数
     */
    IPage<T> setTotal(long total);
    
    /**
     * 获取每页显示条数
     *
     * @return 每页显示条数
     */
    long getSize();
    
    /**
     * 设置每页显示条数
     */
    IPage<T> setSize(long size);
    
    /**
     * 当前页
     *
     * @return 当前页
     */
    long getCurrent();
    
    /**
     * 设置当前页
     */
    IPage<T> setCurrent(long current);
}
