package cn.plusman.arithmetic.leetcode.top.top13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/1 9:59 AM
 */
class Top13ClassTest {
    Top13Solution top13Solution = new Top13Class();
    
    @Test
    void romanToInt() {
        int result;
        
        result = top13Solution.romanToInt("II");
        Assertions.assertEquals(2, result);
    
        result = top13Solution.romanToInt("IV");
        Assertions.assertEquals(4, result);
    
        result = top13Solution.romanToInt("IX");
        Assertions.assertEquals(9, result);
    
        result = top13Solution.romanToInt("LVIII");
        Assertions.assertEquals(58, result);
        
        result = top13Solution.romanToInt("MCMXCIV");
        Assertions.assertEquals(1994, result);
    }
}