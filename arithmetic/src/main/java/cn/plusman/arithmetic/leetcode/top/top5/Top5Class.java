package cn.plusman.arithmetic.leetcode.top.top5;

/**
 * @author plusman
 * @since 2021/6/14 7:34 PM
 */
public class Top5Class implements Top5Solution {
    @Override
    public String longestPalindrome(String s) {
        int m = 0, n = m;
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length - 1; i++) {
            int j = i, k = j;
            
            // 中心扩散
            while (k < chars.length - 1 && chars[k+1] == chars[i]) {
                k++;
            }
            while (j > 0 && chars[j-1] == chars[i]) {
                j--;
            }
            
            while ( j - 1 > -1 && k + 1 < chars.length) {
                if (chars[j-1] != chars[k+1]) {
                    break;
                }
                j--;
                k++;
            }
            
            if ( k - j > n - m) {
                m = j;
                n = k;
            }
        }
        
        return s.substring(m, n + 1);
    }
}
