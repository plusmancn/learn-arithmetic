package cn.plusman.arithmetic.leetcode.top.top5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/6/14 7:34 PM
 */
class Top5ClassTest {
    // Top5Class top5Class = new Top5Class();
    // Top5Class top5Class = new Top5Class();
    Top5Solution top5Solution = new Top5DPClass();
    
    @Test
    void longestPalindrome() {
        String result;
        
        result = top5Solution.longestPalindrome("a");
        assertEquals("a", result);

        result = top5Solution.longestPalindrome("babad");
        assertEquals("aba", result);
        
        result = top5Solution.longestPalindrome("cbbd");
        assertEquals("bb", result);

        result = top5Solution.longestPalindrome("ac");
        assertEquals("a", result);

        result = top5Solution.longestPalindrome("ccc");
        assertEquals("ccc", result);

        result = top5Solution.longestPalindrome("bb");
        assertEquals("bb", result);

        result = top5Solution.longestPalindrome("aaaa");
        assertEquals("aaaa", result);
    }
}