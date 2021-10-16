package cn.plusman.arithmetic.leetcode.top.top128;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/10/16 11:03 PM
 */
class Top128ClassTest {
    // Top128Solution top128Solution = new Top128Class();
    Top128Solution top128Solution = new Top128fficial();
    
    @Test
    void longestConsecutive() {
        int result;
        
        result = top128Solution.longestConsecutive(
            new int[]{
                100,4,200,1,3,2
            }
        );
        Assertions.assertEquals(4, result);
    
        result = top128Solution.longestConsecutive(
            new int[]{
                0,3,7,2,5,8,4,6,0,1
            }
        );
        Assertions.assertEquals(9, result);

        result = top128Solution.longestConsecutive(
            new int[]{
                1,3,3
            }
        );
        Assertions.assertEquals(1, result);

        result = top128Solution.longestConsecutive(
            new int[]{}
        );
        Assertions.assertEquals(0, result);
    }
}