package cn.plusman.arithmetic.leetcode.top.top125;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/29 11:42 PM
 */
class Top125ClassTest {
    Top125Solution top125Solution = new Top125Class();
    
    @Test
    void isPalindrome() {
        boolean result;
        
        // result = top125Solution.isPalindrome("A man, a plan, a canal: Panama");
        // Assertions.assertEquals(true, result);
        //
        // result = top125Solution.isPalindrome("");
        // Assertions.assertEquals(true, result);
        //
        // result = top125Solution.isPalindrome("a");
        // Assertions.assertEquals(true, result);
        //
        // result = top125Solution.isPalindrome("race a car");
        // Assertions.assertEquals(false, result);
    
        result = top125Solution.isPalindrome("0P");
        Assertions.assertEquals(false, result);
    }
}