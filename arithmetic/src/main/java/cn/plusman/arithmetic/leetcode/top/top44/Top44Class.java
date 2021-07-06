package cn.plusman.arithmetic.leetcode.top.top44;

/**
 * @author plusman
 * @since 2021/7/5 9:55 PM
 */
public class Top44Class implements Top44Solution {
    @Override
    public boolean isMatch(String s, String p) {
        // handle empty
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        } else if (p.isEmpty()) {
            return false;
        }  else if (s.isEmpty()) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        
        
        boolean[][] dp = new boolean[p.length()][s.length()];
        boolean firstColEmpty = true;
        
        // fill row by row
        for (int i = 0; i < p.length(); i ++) {
            for (int j = 0; j < s.length(); j++) {
                char ch = p.charAt(i);
                
                if (ch == '*') {
                    if ((i - 1 < 0 || dp[i-1][j]) ||
                        (j > 0 && dp[i][j-1])
                    ) {
                        dp[i][j] = true;
                    }
                } else {
                    if (i - 1 < 0 ||
                        (firstColEmpty && j == 0 && dp[i-1][j]) ||
                        ( j > 0 && dp[i-1][j-1])
                    ) {
                        if (ch == '?') {
                            if (j == 0) {
                                firstColEmpty = false;
                            }
                            
                            dp[i][j] = true;
                        } else {
                            if (ch == s.charAt(j)) {
                                if (j == 0) {
                                    firstColEmpty = false;
                                }
                                
                                dp[i][j] = true;
                            }
                        }
                        
                        // 只能尝试一次
                        if (i == 0) {
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[p.length() - 1][s.length() - 1];
    }
}
