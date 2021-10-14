package cn.plusman.arithmetic.leetcode.top.top127;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/10/14 11:07 PM
 */
class Top127ClassTest {
    Top127Solution top127Solution = new Top127Class();
    
    @Test
    void ladderLength() {
        int result;
        
        result = top127Solution.ladderLength(
            "hit",
            "cog",
            new ArrayList<>(
                Arrays.asList("hot","dot","dog","lot","log","cog")
            )
        );
        Assertions.assertEquals(5, result);
    
        result = top127Solution.ladderLength(
            "hit",
            "cog",
            new ArrayList<>(
                Arrays.asList("hot","dot","dog","lot","log")
            )
        );
        Assertions.assertEquals(0, result);
    }
}