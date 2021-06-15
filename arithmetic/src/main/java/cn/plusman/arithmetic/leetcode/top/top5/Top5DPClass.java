package cn.plusman.arithmetic.leetcode.top.top5;

/**
 * @author plusman
 * @since 2021/6/14 9:23 PM
 */
public class Top5DPClass implements Top5Solution{
    @Override
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int m = 0, n = 0;
        int sl = s.length();
        boolean[][] dpTable = new boolean[sl][sl];
        
        
        // 长度 3 以上处理
        for (int l = 0; l < sl; l++) {
            for(int i = 0; i < sl - l; i++) {
                int j = i + l;
                if (l == 0) {
                    // 长度为 1 处理
                    dpTable[i][j] = true;
                } else if (l == 1) {
                    // 长度为 2 处理
                    dpTable[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dpTable[i][j] = dpTable[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                
                if (dpTable[i][j] && (j - i + 1 > maxLen)) {
                    m = i;
                    n = j;
                    maxLen = i - j + 1;
                }
            }
        }
        
        return s.substring(m, n + 1);
    }
}
