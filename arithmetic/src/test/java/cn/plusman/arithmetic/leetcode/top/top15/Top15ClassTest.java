package cn.plusman.arithmetic.leetcode.top.top15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/1 11:55 PM
 */
class Top15ClassTest {
    Top15Solution top15Solution = new Top15Class();
    
    @Test
    void threeSum() {
        List<List<Integer>> result;
        
        // [-4, -1, -1, 0, 1, 2, 2]
        result = top15Solution.threeSum(new int[]{
            -1,0,0,1,2,2,-1,-4
        });
        System.out.println(result);
        Assertions.assertEquals(3, result.size());

        result = top15Solution.threeSum(new int[]{
            -1,0,0,0,1,2,2,-1,-4
        });
        System.out.println(result);
        Assertions.assertEquals(4, result.size());

        result = top15Solution.threeSum(new int[]{
            -2,0,0,2,2
        });
        System.out.println(result);
        Assertions.assertEquals(1, result.size());

        result = top15Solution.threeSum(new int[]{
            -4,-2,-1
        });
        System.out.println(result);
        Assertions.assertEquals(0, result.size());
        
        result = top15Solution.threeSum(new int[]{
            -2,-3,0,0,-2
        });
        System.out.println(result);
        Assertions.assertEquals(0, result.size());
    }
}