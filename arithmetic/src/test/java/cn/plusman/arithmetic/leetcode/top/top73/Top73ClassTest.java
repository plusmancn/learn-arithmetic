package cn.plusman.arithmetic.leetcode.top.top73;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/14 11:44 PM
 */
class Top73ClassTest {
    Top73Soulution top73Soulution = new Top73Class();
    
    @Test
    void setZeroes() {
        int[][] input = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        top73Soulution.setZeroes(input);
        InspectUtil.showArray(input);
    
    
        input = new int[][]{
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        top73Soulution.setZeroes(input);
        InspectUtil.showArray(input);
    }
}