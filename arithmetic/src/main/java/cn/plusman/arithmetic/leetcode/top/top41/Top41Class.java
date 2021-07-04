package cn.plusman.arithmetic.leetcode.top.top41;

/**
 * @author plusman
 * @since 2021/7/4 9:54 PM
 */
public class Top41Class implements Top41Solution {
    @Override
    public int firstMissingPositive(int[] nums) {
        // bucket sort
        for (int i = 0; i < nums.length; i++) {
            // ignore
            if (nums[i] == i + 1 || nums[i] <=0 || nums[i] > nums.length) {
                continue;
            }
            movePosition(nums, nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
    
    
    private void movePosition(int[] nums, int positionValue, int position) {
        if (positionValue <= 0 || positionValue > nums.length) {
            return;
        }
        
        if (positionValue != position + 1) {
            // clean original value
            if (nums[position] != position +1) {
                nums[position] = -1;
            }
            // move
            int tmp = nums[positionValue - 1];
            nums[positionValue - 1] = positionValue;
            movePosition(nums, tmp, positionValue - 1);
        }
    }
}
