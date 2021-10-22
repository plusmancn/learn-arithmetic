package cn.plusman.arithmetic.leetcode.top.top134;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/10/22 9:36 PM
 */
class Top134MyClassTest {
    Top134Solution top134Solution = new Top134MyClass();
    
    @Test
    void canCompleteCircuit() {
        int result;
        
        result = top134Solution.canCompleteCircuit(
            new int[]{1,2,3,4,5},
            new int[]{3,4,5,1,2}
        );
        Assertions.assertEquals(3, result);

        result = top134Solution.canCompleteCircuit(
            new int[]{2,3,4},
            new int[]{3,4,3}
        );
        Assertions.assertEquals(-1, result);
    
    
        result = top134Solution.canCompleteCircuit(
            new int[]{5,1,2,3,4},
            new int[]{4,4,1,5,1}
        );
        Assertions.assertEquals(4, result);
    }
}