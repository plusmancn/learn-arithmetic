package cn.plusman.arithmetic.leetcode.top.top146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author plusman
 * @since 2021/10/26 9:16 PM
 */
public class LruJvm extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    
    public LruJvm(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
