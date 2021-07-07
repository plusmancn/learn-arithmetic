package cn.plusman.arithmetic.leetcode.top.top53;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/7 10:29 AM
 */
class Top53ClassTest {
    Top53Solution top53Solution = new Top53Class();
    
    @Test
    void maxSubArray() {
        int result;
        
        result = top53Solution.maxSubArray(new int[]{
            -2,1,-3,4,-1,2,1,-5,4
        });
        Assertions.assertEquals(6, result);
    
        result = top53Solution.maxSubArray(new int[]{
            1
        });
        Assertions.assertEquals(1, result);
    }
}