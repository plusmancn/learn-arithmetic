package cn.plusman.arithmetic.leetcode.top.top78;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/16 5:59 PM
 */
class Top78ClassTest {
    Top78Solution top78Solution = new Top78Class();
    
    @Test
    void subsets() {
        List<List<Integer>> result;
        
        result = top78Solution.subsets(new int[]{
            1,2,3
        });
        System.out.println(result);
    
        result = top78Solution.subsets(new int[]{
            0
        });
        System.out.println(result);
    }
}