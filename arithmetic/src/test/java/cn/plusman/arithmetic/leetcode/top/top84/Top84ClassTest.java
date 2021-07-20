package cn.plusman.arithmetic.leetcode.top.top84;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/18 2:39 PM
 */
class Top84ClassTest {
    Top84Solution top84Solution = new Top84StackClass();
    
    @Test
    void largestRectangleArea() {
        int result;
        
        result= top84Solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
        Assertions.assertEquals(10, result);

        result= top84Solution.largestRectangleArea(new int[]{2,4});
        Assertions.assertEquals(4, result);

        result= top84Solution.largestRectangleArea(new int[]{1,1,1,1,1,7,2,2});
        Assertions.assertEquals(8, result);

        result= top84Solution.largestRectangleArea(new int[]{5,4,1,2});
        Assertions.assertEquals(8, result);

        result= top84Solution.largestRectangleArea(new int[]{2,1,4,5,1,3,3});
        Assertions.assertEquals(8, result);

        result= top84Solution.largestRectangleArea(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        Assertions.assertEquals(6, result);

        result= top84Solution.largestRectangleArea(new int[]{4,2,0,3,2,5});
        Assertions.assertEquals(6, result);
    }
}