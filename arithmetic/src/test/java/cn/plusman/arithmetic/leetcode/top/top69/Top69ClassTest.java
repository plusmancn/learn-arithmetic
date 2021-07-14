package cn.plusman.arithmetic.leetcode.top.top69;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/14 2:44 PM
 */
class Top69ClassTest {
    Top69Solution top69Solution = new Top69Class();
    
    @Test
    void mySqrt() {
        int result;
        
        result = top69Solution.mySqrt(4);
        Assertions.assertEquals(2, result);

        result = top69Solution.mySqrt(8);
        Assertions.assertEquals(2, result);

        result = top69Solution.mySqrt(0);
        Assertions.assertEquals(0, result);

        result = top69Solution.mySqrt(188837);
        Assertions.assertEquals(434, result);
    
        result = top69Solution.mySqrt(2147483647);
        Assertions.assertEquals(46340, result);
    }
}