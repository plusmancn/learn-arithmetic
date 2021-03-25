package cn.plusman.mybatis.plugin.pagedir;

import java.util.List;

/**
 * @author plusman
 * @since 2021/3/22 11:48 AM
 */
public class Page<T> implements IPage <T>{
    private long current;
    private long size;
    private long total;
    private List<T> records;
    
    public Page(long current, long size) {
        this.current = current;
        this.size = size;
    }
    
    @Override
    public List<T> getRecords() {
        return this.records;
    }
    
    @Override
    public IPage<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }
    
    @Override
    public long getTotal() {
        return this.total;
    }
    
    @Override
    public IPage<T> setTotal(long total) {
        this.total = total;
        return this;
    }
    
    @Override
    public long getSize() {
        return this.size;
    }
    
    @Override
    public IPage<T> setSize(long size) {
        this.size = size;
        return this;
    }
    
    @Override
    public long getCurrent() {
        return this.current;
    }
    
    @Override
    public IPage<T> setCurrent(long current) {
        return this;
    }
}
