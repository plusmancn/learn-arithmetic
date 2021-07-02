package cn.plusman.arithmetic.leetcode.top.top22;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/2 9:59 PM
 */
class Top22ClassTest {
    Top22Solution top22Solution = new Top22Class();
    
    @Test
    void generateParenthesis() {
        List<String> result;
    
        result = top22Solution.generateParenthesis(1);
        System.out.println(result);
        
        result = top22Solution.generateParenthesis(2);
        System.out.println(result);
    
    
        result = top22Solution.generateParenthesis(3);
        System.out.println(result);
        
    }
}