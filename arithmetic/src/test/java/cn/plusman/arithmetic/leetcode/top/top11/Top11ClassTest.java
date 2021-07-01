package cn.plusman.arithmetic.leetcode.top.top11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/6/30 6:42 PM
 */
class Top11ClassTest {
    // Top11Solution top11Solution = new Top11Class();
    Top11Solution top11Solution = new Top11OfficialClass();
    
    @Test
    void maxArea() {
        int result;
        
        result = top11Solution.maxArea(Arrays.asList(1,8,6,2,5,4,8,3,7).stream().mapToInt(v -> v).toArray());
        Assertions.assertEquals(49, result);

        result = top11Solution.maxArea(Arrays.asList(1,1).stream().mapToInt(v -> v).toArray());
        Assertions.assertEquals(1, result);

        result = top11Solution.maxArea(Arrays.asList(4,3,2,1,4).stream().mapToInt(v -> v).toArray());
        Assertions.assertEquals(16, result);

        result = top11Solution.maxArea(Arrays.asList(1,2,1).stream().mapToInt(v -> v).toArray());
        Assertions.assertEquals(2, result);
    
        result = top11Solution.maxArea(Arrays.asList(10,9,8,7,6,5,4,3,2,1).stream().mapToInt(v -> v).toArray());
        Assertions.assertEquals(25, result);
    }
}