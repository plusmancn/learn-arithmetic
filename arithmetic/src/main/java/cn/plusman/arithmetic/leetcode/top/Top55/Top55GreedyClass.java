package cn.plusman.arithmetic.leetcode.top.Top55;

/**
 * @author plusman
 * @since 2021/7/7 9:44 PM
 */
public class Top55GreedyClass implements Top55Solution {
    @Override
    public boolean canJump(int[] nums) {
        int remotestIndex = 0;
        int lastIndex = nums.length - 1;
    
        if (remotestIndex >= lastIndex) {
            return true;
        }
        
        boolean[] visited = new boolean[nums.length]; 
    
        for (int i = 0; i <= remotestIndex; i++) {
            if (visited[i]) {
                continue;
            }
            
            int j = i;
            while (nums[j] != 0) {
                visited[j] = true;
                j += nums[j];
                remotestIndex = Math.max(remotestIndex, j);
                
                if (remotestIndex >= lastIndex) {
                    return true;
                }
            }
            
            visited[j] = true;
        }
        
        return false;
    }
}
