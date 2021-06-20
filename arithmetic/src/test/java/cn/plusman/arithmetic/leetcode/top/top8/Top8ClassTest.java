package cn.plusman.arithmetic.leetcode.top.top8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/6/20 10:12 PM
 */
class Top8ClassTest {
    Top8Solution solution = new Top8Class();
    
    @Test
    void myAtoi() {
        String input;
        int res;
        
        input = "-91283472332";
        res = solution.myAtoi(input);
        Assertions.assertEquals(-2147483648, res);

        input = "42";
        res = solution.myAtoi(input);
        Assertions.assertEquals(42, res);

        input = "   -42";
        res = solution.myAtoi(input);
        Assertions.assertEquals(-42, res);

        input = "4193 with words";
        res = solution.myAtoi(input);
        Assertions.assertEquals(4193, res);

        input = "words and 987";
        res = solution.myAtoi(input);
        Assertions.assertEquals(0, res);

        input = "2147483646";
        res = solution.myAtoi(input);
        Assertions.assertEquals(2147483646, res);

        input = "-2147483649";
        res = solution.myAtoi(input);
        Assertions.assertEquals(-2147483648, res);
    
        input = "-2147483647";
        res = solution.myAtoi(input);
        Assertions.assertEquals(-2147483647, res);
    }
}