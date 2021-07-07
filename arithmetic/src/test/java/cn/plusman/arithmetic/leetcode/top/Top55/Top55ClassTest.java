package cn.plusman.arithmetic.leetcode.top.Top55;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/7 5:21 PM
 */
class Top55ClassTest {
    Top55Solution top55Solution = new Top55GreedyClass();
    
    @Test
    void canJump() {
        boolean result;
        
        result = top55Solution.canJump(new int[]{2,3,1,1,4});
        Assertions.assertEquals(true, result);

        result = top55Solution.canJump(new int[]{3,2,1,0,4});
        Assertions.assertEquals(false, result);

        result = top55Solution.canJump(new int[]{1});
        Assertions.assertEquals(true, result);
    
        result = top55Solution.canJump(new int[]{0});
        Assertions.assertEquals(true, result);

        result = top55Solution.canJump(new int[]{3,0,8,2,0,0,1});
        Assertions.assertEquals(true, result);
    }
}