package cn.plusman.arithmetic.leetcode.top.top56;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/7 10:59 PM
 */
class Top56ClassTest {
    Top56Solution top56Solution = new Top56Class();
    
    @Test
    void merge() {
        int[][] result;
        
        result = top56Solution.merge(new int[][]{
            {1,3},{2,6},{8,10},{15,18}
        });
        InspectUtil.showArray(result);

        result = top56Solution.merge(new int[][]{
            {1,4},{4,5}
        });
        InspectUtil.showArray(result);

        result = top56Solution.merge(new int[][]{
            {1,1}
        });
        InspectUtil.showArray(result);
    
        result = top56Solution.merge(new int[][]{
            {1,4},{0,1},{4, 10}
        });
        InspectUtil.showArray(result);
    }
}