package cn.plusman.arithmetic.leetcode.top.top10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/6/30 12:17 AM
 */
class Top10SolutionTest {
    Top10Solution top10Solution = new Top10Class();
    
    @Test
    void isMatch() {
        Boolean result;
        
        result = top10Solution.isMatch("mississippi", "mis*is*p*.");
        Assertions.assertEquals(false, result);

        result = top10Solution.isMatch("aa", "a");
        Assertions.assertEquals(false, result);

        result = top10Solution.isMatch("aa", "a*");
        Assertions.assertEquals(true, result);

        result = top10Solution.isMatch("", "a");
        Assertions.assertEquals(false, result);

        result = top10Solution.isMatch("", "a*");
        Assertions.assertEquals(true, result);

        result = top10Solution.isMatch("dd", "");
        Assertions.assertEquals(false, result);

        result = top10Solution.isMatch("", "");
        Assertions.assertEquals(true, result);

        result = top10Solution.isMatch("ab", ".*");
        Assertions.assertEquals(true, result);

        result = top10Solution.isMatch("aab", "c*a*b");
        Assertions.assertEquals(true, result);
    
        result = top10Solution.isMatch("abcd", "d*");
        Assertions.assertEquals(false, result);
    }
}