package cn.plusman.arithmetic.leetcode.top.Top55;

/**
 * DP
 * @author plusman
 * @since 2021/7/7 5:21 PM
 */
public class Top55DPClass implements Top55Solution {
    @Override
    public boolean canJump(int[] nums) {
        int size = nums.length;
        boolean[][] dp = new boolean[size][size];
        
        for (int j = 0; j < nums.length; j++) {
            if (j - 1 < 0 || dp[j][j-1]) {
                dp[j][j] = true;
            } else {
                break;
            }
            
            int jHigh = j + nums[j];
            if (jHigh >= size - 1) {
                return true;
            }
            
            int i;
            for(i = j + 1; i <= jHigh; i++) {
                dp[i][j] = true;
            }
            while (j > 0 && dp[i][j-1]) {
                dp[i][j] = true;
                i++;
            }
        }
        
        return dp[size - 1][size - 1];
    }
}
