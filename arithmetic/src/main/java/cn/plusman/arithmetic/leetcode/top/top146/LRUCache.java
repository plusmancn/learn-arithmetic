package cn.plusman.arithmetic.leetcode.top.top146;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于双向列表，更新和查询复杂度都为 O(1) 的请求
 * @author plusman
 * @since 2021/10/26 10:05 PM
 */
public class LRUCache {
    private static class DlinkedListtNode {
        public int key;
        public int value;
        public DlinkedListtNode prev, next;
        DlinkedListtNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    DlinkedListtNode head,tail;
    
    private int capacity, size = 0;
    private Map<Integer, DlinkedListtNode> cache = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head = new DlinkedListtNode(-1, -1);
        tail = new DlinkedListtNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DlinkedListtNode valueNode = cache.get(key);
        
        if (valueNode != null) {
            moveToHead(valueNode);
            return valueNode.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        DlinkedListtNode valueNode = cache.get(key);
        // 需要新增
        if (valueNode ==  null) {
            valueNode = new DlinkedListtNode(key, value);
            
            addToHead(valueNode);
            cache.put(key, valueNode);
            size++;
            
            // 超过容量上限，需要进行逐出
            if (size > capacity) {
                int removeKey = removeFromTail();
                cache.remove(removeKey);
                size--;
            }
        } else {
            // 进行更新操作
            valueNode.value = value;
            moveToHead(valueNode);
        }
    }
    
    private void addToHead(DlinkedListtNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void moveToHead(DlinkedListtNode node) {
        // 本来就在头部，没必要进行移动
        if (node.prev == head) {
            return;
        }
        
        // 先移除
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        // 再添加
        addToHead(node);
    }
    
    private int removeFromTail() {
        DlinkedListtNode node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = tail;
        
        return node.key;
    }
}
