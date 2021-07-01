package cn.plusman.arithmetic.leetcode.top.top14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/1 11:21 AM
 */
class Top14ClassTest {
    Top14Solution top14Solution = new Top14Class();
    
    @Test
    void longestCommonPrefix() {
        String result;
        
        result = top14Solution.longestCommonPrefix(new String[]{"flower","flow","flight"});
        Assertions.assertEquals("fl", result);
    
        result = top14Solution.longestCommonPrefix(new String[]{"dog","racecar","car"});
        Assertions.assertEquals("", result);
    
        result = top14Solution.longestCommonPrefix(new String[]{});
        Assertions.assertEquals("", result);
    
        result = top14Solution.longestCommonPrefix(new String[]{"", "b"});
        Assertions.assertEquals("", result);
    
        result = top14Solution.longestCommonPrefix(new String[]{"cir","car"});
        Assertions.assertEquals("c", result);
    }
}