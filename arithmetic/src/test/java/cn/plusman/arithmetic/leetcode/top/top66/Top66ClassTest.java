package cn.plusman.arithmetic.leetcode.top.top66;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/13 5:55 PM
 */
class Top66ClassTest {
    Top66Solution top66Solution = new Top66Class();
    
    @Test
    void plusOne() {
        int[] result;
        
        result = top66Solution.plusOne(new int[]{4,3,2,1});
        System.out.println(Arrays.toString(result));
    
        result = top66Solution.plusOne(new int[]{9});
        System.out.println(Arrays.toString(result));
    }
}