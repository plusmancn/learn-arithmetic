package cn.plusman.arithmetic.leetcode.top.top136;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/10/25 12:38 PM
 */
class Top136MyClassTest {
    Top136Solution top136Solution  = new Top136OfficialClass();
    
    @Test
    void singleNumber() {
        int result;
        
        result = top136Solution.singleNumber(new int[]{2,2,1});
        Assertions.assertEquals(1, result);
        
        result = top136Solution.singleNumber(new int[]{4,1,2,1,2});
        Assertions.assertEquals(4, result);
    }
}