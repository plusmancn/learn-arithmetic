package cn.plusman.arithmetic.leetcode.top.top54;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/7 3:25 PM
 */
class Top54ClassTest {
    Top54Solution top54Solution = new Top54Class();
    
    @Test
    void spiralOrder() {
        List<Integer> result;
        
        result = top54Solution.spiralOrder(new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        });
        System.out.println(result);

        result = top54Solution.spiralOrder(new int[][]{
            {1},
            {4},
            {7}
        });
        System.out.println(result);
    
        result = top54Solution.spiralOrder(new int[][]{
            {1}
        });
        System.out.println(result);
    
        result = top54Solution.spiralOrder(new int[][]{
            {1,2,3}
        });
        System.out.println(result);
    }
}