package cn.plusman.arithmetic.leetcode.top.top44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/5 10:09 PM
 */
class Top44ClassTest {
    Top44Solution top44Solution = new Top44Class();
    
    @Test
    void isMatch() {
        boolean result;
        
        result = top44Solution.isMatch("", "");
        Assertions.assertEquals(true, result);

        result = top44Solution.isMatch("", "*");
        Assertions.assertEquals(true, result);

        result = top44Solution.isMatch("", "*?");
        Assertions.assertEquals(false, result);

        result = top44Solution.isMatch("str", "");
        Assertions.assertEquals(false, result);

        result = top44Solution.isMatch("aa", "a");
        Assertions.assertEquals(false, result);

        result = top44Solution.isMatch("aa", "*");
        Assertions.assertEquals(true, result);

        result = top44Solution.isMatch("cb", "?a");
        Assertions.assertEquals(false, result);

        result = top44Solution.isMatch("adceb", "*a*b");
        Assertions.assertEquals(true, result);

        result = top44Solution.isMatch("acdcb", "a*c?b");
        Assertions.assertEquals(false, result);

        result = top44Solution.isMatch("aab", "c*a*b");
        Assertions.assertEquals(false, result);

        result = top44Solution.isMatch("abcabczzzde", "*abc???de*");
        Assertions.assertEquals(true, result);

        result = top44Solution.isMatch("b", "?*?");
        Assertions.assertEquals(false, result);

        result = top44Solution.isMatch("aaab", "b**");
        Assertions.assertEquals(false, result);
        
        result = top44Solution.isMatch("zacabz", "*a?b*");
        Assertions.assertEquals(false, result);
    }
}