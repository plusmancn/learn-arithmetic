package cn.plusman.arithmetic.leetcode.top.top70;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/14 3:57 PM
 */
class Top70ClassTest {
    Top70Solution top70Solution = new Top70Class();
    
    @Test
    void climbStairs() {
        int result;
        
        result = top70Solution.climbStairs(1);
        Assertions.assertEquals(1, result);
    
        result = top70Solution.climbStairs(2);
        Assertions.assertEquals(2, result);
    
        result = top70Solution.climbStairs(3);
        Assertions.assertEquals(3, result);
    
        result = top70Solution.climbStairs(4);
        Assertions.assertEquals(5, result);
    }
}