package cn.plusman.arithmetic.leetcode.top.top3;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/6/6 4:29 PM
 */
class Top3ClassTest {
    Top3Class top3Class = new Top3Class();
    
    @Test
    void lengthOfLongestSubstring() {
        int l;
    
        l = top3Class.lengthOfLongestSubstring("pwwkew");
        Assertions.assertEquals(3, l);
    
        l = top3Class.lengthOfLongestSubstring("");
        Assertions.assertEquals(0, l);
    
        l = top3Class.lengthOfLongestSubstring("bbbbb");
        Assertions.assertEquals(1, l);
        
        l = top3Class.lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(3, l);
    }
}