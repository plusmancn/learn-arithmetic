package cn.plusman.arithmetic.leetcode.top.top8;

import cn.plusman.arithmetic.leetcode.top.top7.Top7Solution;

/**
 * @author plusman
 * @since 2021/6/20 9:53 PM
 */
public class Top8Class implements Top8Solution {
    @Override
    public int myAtoi(String s) {
        boolean inTrimSpace = true;
        boolean inLookSign = true;
        int sign = 1;
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (inTrimSpace && c == ' ') {
                continue;
            }
            
            if (inLookSign && (c == '-' || c == '+')) {
                if (c == '-') {
                    sign = -1;
                }
                inTrimSpace = false;
                inLookSign = false;
                continue;
            }
            
            if('0' <= c && c <= '9') {
                inTrimSpace = false;
                inLookSign = false;
                
                int digit = sign * (c - '0');
    
                // 溢出判断，代码复杂，逻辑简单
                if (Integer.MAX_VALUE / 10 < res) {
                    return Integer.MAX_VALUE;
                } else if (Integer.MIN_VALUE / 10 > res) {
                    return Integer.MIN_VALUE;
                }  else if (Integer.MAX_VALUE / 10 == res) {
                    if (Integer.MAX_VALUE % 10 < digit) {
                        return Integer.MAX_VALUE;
                    }
                } else if (Integer.MIN_VALUE / 10 == res) {
                    if (Integer.MIN_VALUE % 10 > digit) {
                        return Integer.MIN_VALUE;
                    }
                }
    
                res = res * 10 + digit;
            } else {
                break;
            }
        }
        
        return res;
    }
}
