package cn.plusman.arithmetic.leetcode.top.top122;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/28 5:17 PM
 */
class Top122ClassTest {
    Top122Solution top122Solution = new Top122Class();
    
    @Test
    void maxProfit() {
        int result;
        
        result = top122Solution.maxProfit(new int[]{
            7,1,5,3,6,4
        });
        Assertions.assertEquals(7, result);
    
        result = top122Solution.maxProfit(new int[]{
            1,2,3,4,5
        });
        Assertions.assertEquals(4, result);
    
        result = top122Solution.maxProfit(new int[]{
            7,6,4,3,1
        });
        Assertions.assertEquals(0, result);
    }
}