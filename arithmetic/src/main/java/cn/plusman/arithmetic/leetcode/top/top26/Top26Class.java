package cn.plusman.arithmetic.leetcode.top.top26;

import java.util.List;

/**
 * @author plusman
 * @since 2021/7/2 11:21 PM
 */
public class Top26Class implements Top26Solution {
    @Override
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        // index number, not size
        int k = 0;
        for (int j = 1 ; j < nums.length; j++) {
            if (nums[j-1] != nums[j]) {
                k++;
                nums[k] = nums[j];
            }
        }
        
        // index + 1 = size
        return k + 1;
    }
}
