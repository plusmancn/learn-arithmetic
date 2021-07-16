package cn.plusman.arithmetic.leetcode.top.top76;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/15 10:58 PM
 */
class Top76ClassTest {
    Top76Solution top76Solution = new Top76OfficialClass();
    
    @Test
    void minWindow() {
        String result;
        
        result = top76Solution.minWindow("ADOBECODEBANC", "ABC");
        Assertions.assertEquals("BANC", result);

        result = top76Solution.minWindow("a", "a");
        Assertions.assertEquals("a", result);

        result = top76Solution.minWindow("a", "aa");
        Assertions.assertEquals("", result);

        result = top76Solution.minWindow("bba", "ab");
        Assertions.assertEquals("ba", result);

        result = top76Solution.minWindow("b", "a");
        Assertions.assertEquals("", result);
    
        result = top76Solution.minWindow("acbbaca", "aba");
        Assertions.assertEquals("baca", result);
    }
}