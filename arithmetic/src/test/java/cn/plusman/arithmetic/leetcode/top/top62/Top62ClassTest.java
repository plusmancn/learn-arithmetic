package cn.plusman.arithmetic.leetcode.top.top62;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/13 2:55 PM
 */
class Top62ClassTest {
    Top62Solution top62Solution = new Top62Class();
    
    @Test
    void uniquePaths() {
        int result;
        
        result = top62Solution.uniquePaths(3, 7);
        Assertions.assertEquals(28, result);
    
        result = top62Solution.uniquePaths(7, 3);
        Assertions.assertEquals(28, result);
    
        result = top62Solution.uniquePaths(3, 2);
        Assertions.assertEquals(3, result);
    
        result = top62Solution.uniquePaths(1, 1);
        Assertions.assertEquals(1, result);
    
        result = top62Solution.uniquePaths(3, 3);
        Assertions.assertEquals(6, result);
    }
}