package cn.plusman.arithmetic.leetcode.top.top53;

/**
 * @author plusman
 * @since 2021/7/7 10:29 AM
 */
public class Top53Class implements Top53Solution {
    @Override
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            
            if (sum <= 0) {
                sum = 0;
            }
        }
        
        return max;
    }
}
