package cn.plusman.arithmetic.leetcode.top.top66;

import java.util.Arrays;

/**
 * @author plusman
 * @since 2021/7/13 5:55 PM
 */
public class Top66Class implements Top66Solution {
    @Override
    public int[] plusOne(int[] digits) {
        int prev = 1;
        for (int i = digits.length - 1; i >=0; i--) {
            int cur = digits[i] + prev;
            digits[i] = cur % 10;
            prev = cur / 10;
            
            if (prev == 0) {
                return digits;
            }
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
