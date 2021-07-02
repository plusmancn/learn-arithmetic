package cn.plusman.arithmetic.leetcode.top.top17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/2 12:57 PM
 */
class Top17ClassTest {
    Top17Solution top17Solution = new Top17Class();
    
    @Test
    void letterCombinations() {
        List<String> result; 
        
        result = top17Solution.letterCombinations("22");
        System.out.println(result);
        Assertions.assertEquals(9, result.size());
    
    
        result = top17Solution.letterCombinations("9");
        System.out.println(result);
        Assertions.assertEquals(4, result.size());
    
        result = top17Solution.letterCombinations("32");
        System.out.println(result);
        Assertions.assertEquals(9, result.size());
    
        result = top17Solution.letterCombinations("");
        System.out.println(result);
        Assertions.assertEquals(0, result.size());
    }
}