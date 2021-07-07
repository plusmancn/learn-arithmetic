package cn.plusman.arithmetic.leetcode.top.Top55;

/**
 * @author plusman
 * @since 2021/7/7 10:15 PM
 */
public class Top55Greedy2Class implements Top55Solution {
    
    @Override
    public boolean canJump(int[] nums) {
        int remotestIndex = 0;
        int lastIndex = nums.length - 1;
        
        for (int i = 0; i <= remotestIndex; i++) {
            remotestIndex = Math.max(remotestIndex, i + nums[i]);
            
            if (remotestIndex >= lastIndex) {
                return true;
            }
        }
        
        return false;
    }
}
