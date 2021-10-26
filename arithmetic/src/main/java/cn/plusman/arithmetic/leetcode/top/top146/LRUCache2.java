package cn.plusman.arithmetic.leetcode.top.top146;

import java.util.*;

/**
 * 一个失败的版本
 * @author plusman
 * @since 2021/10/26 12:52 PM
 */
public class LRUCache2 {
    private int capacity;
    private List<Integer> lruList = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap();
    
    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = map.get(key);
        if (value != null) {
            updateLruList(key);
            return value.intValue();
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        // 可能需要执行 LRU 驱逐
        if (map.size() >= capacity) {
            Integer storedValue = map.get(key);
            if (storedValue == null) {
                // 执行驱逐逻辑
                map.remove(evictLruList(key));
            } else {
                updateLruList(key);
            }
        } else {
            lruList.add(0, key);
        }
        
        map.put(key, value);
    }
    
    /**
     * 更新键值最近活跃度
     * @param oldKey
     */
    private void updateLruList(Integer oldKey) {
        for (int i = 0; i < lruList.size(); i++) {
            if (lruList.get(i).equals(oldKey)) {
                lruList.remove(i);
                lruList.add(0, oldKey);
                break;
            }
        }
    }
    
    /**
     * 驱逐过期 Key
     * @param newKey
     * @return 返回过期 key 的值
     */
    private Integer evictLruList(Integer newKey) {
        lruList.add(0, newKey);
        return lruList.remove(lruList.size() - 1);
    }
}
