package cn.plusman.arithmetic.leetcode.top.top118;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/23 5:45 PM
 */
class Top118ClassTest {
    Top118Solution top118Solution = new Top118Class();
    
    @Test
    void generate() {
        List<List<Integer>> result;
        
        result = top118Solution.generate(3);
        System.out.println(result);
    
        result = top118Solution.generate(2);
        System.out.println(result);
        
        result = top118Solution.generate(1);
        System.out.println(result);
    }
}