package cn.plusman.arithmetic.leetcode.top.top131;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/10/22 10:28 AM
 */
class Top131ClassTest {
    Top131Solution top131Solution = new Top131Class();
    
    @Test
    void partition() {
        List<List<String>> result;
        
        // result = top131Solution.partition("aab");
        // System.out.println(result);
    
        result = top131Solution.partition("abbba");
        System.out.println(result);
    }
}