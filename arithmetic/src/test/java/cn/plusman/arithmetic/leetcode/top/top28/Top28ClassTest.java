package cn.plusman.arithmetic.leetcode.top.top28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/3 2:19 PM
 */
class Top28ClassTest {
    Top28Solution top28Solution = new Top28Class();
    
    @Test
    void strStr() {
        int result;
        
        result = top28Solution.strStr("hello", "ll");
        Assertions.assertEquals(2, result);
    
        result = top28Solution.strStr("aaaaa", "bba");
        Assertions.assertEquals(-1, result);
    
        result = top28Solution.strStr("", "");
        Assertions.assertEquals(0, result);
    
        result = top28Solution.strStr("", "a");
        Assertions.assertEquals(-1, result);
    }
}