package cn.plusman.arithmetic.leetcode.top.top20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author plusman
 * @since 2021/7/2 4:03 PM
 */
class Top20ClassTest {
    Top20Solution top20Solution = new Top20Class();
    
    @Test
    void isValid() {
        boolean result;
        
        result = top20Solution.isValid("()[]{}");
        Assertions.assertEquals(true, result);
    
        result = top20Solution.isValid("()");
        Assertions.assertEquals(true, result);
    
        result = top20Solution.isValid("(]");
        Assertions.assertEquals(false, result);
    
        result = top20Solution.isValid("([)]");
        Assertions.assertEquals(false, result);
    
        result = top20Solution.isValid("{[]}");
        Assertions.assertEquals(true, result);
    
        result = top20Solution.isValid("");
        Assertions.assertEquals(true, result);
    }
}