package cn.plusman.arithmetic.leetcode.top.top121;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/28 12:50 PM
 */
class Top121ClassTest {
    Top121Solution top121Solution = new Top121Official();
    
    @Test
    void maxProfit() {
        int result;
        
        result = top121Solution.maxProfit(new int[]{
            7,1,5,3,6,4
        });
        Assertions.assertEquals(5, result);
        
        result = top121Solution.maxProfit(new int[]{
            7,6,4,3,1
        });
        Assertions.assertEquals(0, result);

        result = top121Solution.maxProfit(new int[]{
            2,1,4
        });
        Assertions.assertEquals(3, result);
    }
}