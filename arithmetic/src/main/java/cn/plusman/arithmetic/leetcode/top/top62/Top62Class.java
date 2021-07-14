package cn.plusman.arithmetic.leetcode.top.top62;

/**
 * @author plusman
 * @since 2021/7/13 2:55 PM
 */
public class Top62Class implements Top62Solution {
    @Override
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // bottom row
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        
        // right column
        for (int i = 1; i < m; i++) {
            dp[i][n-1] = 1;
        }
        
        // fill other
        for (int i = 1; i < m; i++) {
            for (int j = n - 2; j >=0; j--) {
                dp[i][j] = dp[i-1][j] + dp[i][j+1]; 
            }
        }
        
        return dp[m-1][0];
    }
}
