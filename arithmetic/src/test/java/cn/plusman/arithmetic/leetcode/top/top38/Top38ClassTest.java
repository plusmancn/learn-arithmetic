package cn.plusman.arithmetic.leetcode.top.top38;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/4 9:22 PM
 */
class Top38ClassTest {
    Top38Solution top38Solution = new Top38Class();
    
    @Test
    void countAndSay() {
        String result;
        
        result = top38Solution.countAndSay(1);
        Assertions.assertEquals("1", result);
    
        result = top38Solution.countAndSay(2);
        Assertions.assertEquals("11", result);
    
        result = top38Solution.countAndSay(3);
        Assertions.assertEquals("21", result);
    
        result = top38Solution.countAndSay(4);
        Assertions.assertEquals("1211", result);
    
        result = top38Solution.countAndSay(5);
        Assertions.assertEquals("111221", result);
    }
}