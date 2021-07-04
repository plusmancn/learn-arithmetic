package cn.plusman.arithmetic.leetcode.top.top41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/4 9:54 PM
 */
class Top41ClassTest {
    Top41Solution top41Solution = new Top41Class();
    
    @Test
    void firstMissingPositive() {
        int result;
    
        result = top41Solution.firstMissingPositive(new int[]{
            2, 1
        });
        Assertions.assertEquals(3, result);
    
        result = top41Solution.firstMissingPositive(new int[]{
            1,2,0
        });
        Assertions.assertEquals(3, result);

        result = top41Solution.firstMissingPositive(new int[]{
            3,4,-1,1
        });
        Assertions.assertEquals(2, result);

        result = top41Solution.firstMissingPositive(new int[]{
            7,8,9,11,12
        });
        Assertions.assertEquals(1, result);
        
    }
}