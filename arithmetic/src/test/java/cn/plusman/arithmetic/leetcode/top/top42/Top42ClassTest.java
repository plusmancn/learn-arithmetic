package cn.plusman.arithmetic.leetcode.top.top42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/5 4:23 PM
 */
class Top42ClassTest {
    Top42Solution top42Solution = new Top42ColumnClass();
    
    @Test
    void trap() {
        int result;
        
        result = top42Solution.trap(new int[]{
            0,1,0,2,1,0,1,3,2,1,2,1
        });
        Assertions.assertEquals(6, result);

        result = top42Solution.trap(new int[]{
            4,2,0,3,2,5
        });
        Assertions.assertEquals(9, result);

        result = top42Solution.trap(new int[]{
            5,5,1,7,1,1,5,2,7,6
        });
        Assertions.assertEquals(23, result);
    
        result = top42Solution.trap(new int[]{});
        Assertions.assertEquals(0, result);
    }
}