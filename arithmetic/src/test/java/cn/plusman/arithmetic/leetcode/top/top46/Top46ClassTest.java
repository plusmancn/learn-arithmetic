package cn.plusman.arithmetic.leetcode.top.top46;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/6 1:48 PM
 */
class Top46ClassTest {
    Top46Solution top46Solution = new Top46Class();
    
    @Test
    void permute() {
        List<List<Integer>> result;
        
        result = top46Solution.permute(new int[]{
            1,2,3
        });
        System.out.println(result);
    
        result = top46Solution.permute(new int[]{
            1
        });
        System.out.println(result);
    
        result = top46Solution.permute(new int[]{
            2
        });
        System.out.println(result);
    }
}