package cn.plusman.arithmetic.leetcode.top.top7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/6/15 12:24 PM
 */
class TopClassTest {
    Top7Solution top7Solution = new Top7Class();
    
    @Test
    void reverse() {
        int result;
        
        result = top7Solution.reverse(-123);
        Assertions.assertEquals(-321, result);
        
        result = top7Solution.reverse(123);
        Assertions.assertEquals(321, result);
        
        result = top7Solution.reverse(120);
        Assertions.assertEquals(21, result);
        
        result = top7Solution.reverse(0);
        Assertions.assertEquals(0, result);
        
        result = top7Solution.reverse(1534236469);
        Assertions.assertEquals(0, result);
    }
}