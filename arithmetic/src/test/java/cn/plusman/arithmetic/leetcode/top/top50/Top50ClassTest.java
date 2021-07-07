package cn.plusman.arithmetic.leetcode.top.top50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/6 6:20 PM
 */
class Top50ClassTest {
    Top50Solution top50Solution = new Top50Class();
    
    @Test
    void myPow() {
        double result;
        
        result = top50Solution.myPow(2.0, 4);
        Assertions.assertEquals(16, result);

        result = top50Solution.myPow(2.0, -2);
        Assertions.assertEquals(0.25, result);

        result = top50Solution.myPow(2.0, 0);
        Assertions.assertEquals(1.0, result);
    
        result = top50Solution.myPow(2.00000, -2147483648);
        Assertions.assertEquals(0, result);
    }
}