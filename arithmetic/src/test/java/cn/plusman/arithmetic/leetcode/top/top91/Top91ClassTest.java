package cn.plusman.arithmetic.leetcode.top.top91;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/19 7:19 AM
 */
class Top91ClassTest {
    Top91Solution top91Solution = new Top91Class();
    
    @Test
    void numDecodings() {
        int result;
        
        result = top91Solution.numDecodings("11106");
        Assertions.assertEquals(2, result);

        result = top91Solution.numDecodings("296");
        Assertions.assertEquals(1, result);

        result = top91Solution.numDecodings("12");
        Assertions.assertEquals(2, result);

        result = top91Solution.numDecodings("226");
        Assertions.assertEquals(3, result);

        result = top91Solution.numDecodings("06");
        Assertions.assertEquals(0, result);
    
        result = top91Solution.numDecodings("717");
        Assertions.assertEquals(2, result);
    
        result = top91Solution.numDecodings("2611055971756562");
        Assertions.assertEquals(4, result);
    }
}