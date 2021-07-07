package cn.plusman.arithmetic.leetcode.top.top48;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/6 3:56 PM
 */
class Top48ClassTest {
    Top48Solution top48Solution = new Top48Class();
    
    @Test
    void rotate() {
        int[][] matrix;
        
        matrix = new int[][]{
            {1,2,3},
            {4,5,6}, 
            {7,8,9}
        };
        top48Solution.rotate(matrix);
        InspectUtil.showArray(matrix);
    
        matrix = new int[][]{
            {1,2},
            {3,4}
        };
        top48Solution.rotate(matrix);
        InspectUtil.showArray(matrix);
    
        matrix = new int[][]{
            {1}
        };
        top48Solution.rotate(matrix);
        InspectUtil.showArray(matrix);
    }
}