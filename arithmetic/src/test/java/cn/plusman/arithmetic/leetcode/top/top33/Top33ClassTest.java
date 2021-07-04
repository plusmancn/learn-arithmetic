package cn.plusman.arithmetic.leetcode.top.top33;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/3 4:09 PM
 */
class Top33ClassTest {
    Top33Solution top33Solution = new Top33Class();
    
    @Test
    void search() {
        int result;
    
        result = top33Solution.search(new int[]{5,1,2,3,4}, 1);
        Assertions.assertEquals(1, result);
        
        result = top33Solution.search(new int[]{4,5,6,7,8,1,2,3}, 8);
        Assertions.assertEquals(4, result);

        result = top33Solution.search(new int[]{5,1,3}, 4);
        Assertions.assertEquals(-1, result);

        result = top33Solution.search(new int[]{4,5,6,7,0,1,2}, 4);
        Assertions.assertEquals(0, result);

        result = top33Solution.search(new int[]{4,5,6,7,0,1,2}, 0);
        Assertions.assertEquals(4, result);

        result = top33Solution.search(new int[]{4,5,6,7,0,1,2}, 3);
        Assertions.assertEquals(-1, result);

        result = top33Solution.search(new int[]{1}, 0);
        Assertions.assertEquals(-1, result);

        result = top33Solution.search(new int[]{0}, 0);
        Assertions.assertEquals(0, result);

        result = top33Solution.search(new int[]{1,3}, 3);
        Assertions.assertEquals(1, result);

        result = top33Solution.search(new int[]{1,3}, 4);
        Assertions.assertEquals(-1, result);
    }
}