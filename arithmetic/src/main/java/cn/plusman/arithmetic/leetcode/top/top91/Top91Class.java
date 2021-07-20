package cn.plusman.arithmetic.leetcode.top.top91;

import java.util.Arrays;

/**
 * @author plusman
 * @since 2021/7/19 7:19 AM
 */
public class Top91Class implements Top91Solution {
    private int[] cache;
    
    @Override
    public int numDecodings(String s) {
        cache = new int[s.length() + 1];
        Arrays.fill(cache, -1);
        return loopStack(s, s.length() , 0);
    }
    
    protected int loopStack(String s, int n, int i) {
        if (cache[i] != -1) {
            return cache[i];
        }
        
        if (i >= n) {
            cache[i] = 1;
            return 1;
        }
        char ch1 = s.charAt(i);
        
        if (ch1 == '0') {
            cache[i] = 0;
            return 0;
        }
        
        int left = loopStack(s, n, i + 1);
        
        int right = 0;
        if (ch1 < '3' && i + 1 < n ) {
            char ch2 = s.charAt(i + 1);
            int value = (ch1 - '0') * 10 + (ch2 - '0');
            if (value <= 26) {
                right = loopStack(s, n, i + 2);
            }
        }
        
        cache[i] = left + right;
        return left + right;
    }
}
