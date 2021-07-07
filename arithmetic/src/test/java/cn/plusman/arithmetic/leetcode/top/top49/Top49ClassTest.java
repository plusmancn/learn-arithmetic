package cn.plusman.arithmetic.leetcode.top.top49;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/6 5:38 PM
 */
class Top49ClassTest {
    Top49Solution top49Solution = new Top49Class();
    
    @Test
    void groupAnagrams() {
        List<List<String>> result;
        
        result = top49Solution.groupAnagrams(new String[]{
            "eat","tea","tan","ate","nat","bat","eatt", "ttea"
        });
        System.out.println(result);
    }
}