package cn.plusman.arithmetic.leetcode.top.top146;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/10/26 12:52 PM
 */
class LRUCacheTest {
    @Test
    void debug() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        Assertions.assertEquals(1, lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        Assertions.assertEquals(-1, lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        Assertions.assertEquals(-1, lRUCache.get(1));
        Assertions.assertEquals(3, lRUCache.get(3));
        Assertions.assertEquals(4, lRUCache.get(4));
    }
}