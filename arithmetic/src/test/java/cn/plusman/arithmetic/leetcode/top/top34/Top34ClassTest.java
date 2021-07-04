package cn.plusman.arithmetic.leetcode.top.top34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/3 8:32 PM
 */
class Top34ClassTest {
    Top34Solution top34Solution = new Top34Class();
    
    @Test
    void searchRange() {
        int[] result;
        
        result = top34Solution.searchRange(
            new int[]{5,7,7,8,8,10},
            8
        );
        Assertions.assertEquals("[3, 4]", Arrays.toString(result));
    
        result = top34Solution.searchRange(
            new int[]{5,7,7,8,10},
            8
        );
        Assertions.assertEquals("[3, 3]", Arrays.toString(result));
    
    
        result = top34Solution.searchRange(
            new int[]{5,7,7,8,8,10},
            6
        );
        Assertions.assertEquals("[-1, -1]", Arrays.toString(result));
        
        result = top34Solution.searchRange(
            new int[]{},
            0
        );
        Assertions.assertEquals("[-1, -1]", Arrays.toString(result));
    }
}