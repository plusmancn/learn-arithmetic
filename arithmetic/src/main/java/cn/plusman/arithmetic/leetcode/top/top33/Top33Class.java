package cn.plusman.arithmetic.leetcode.top.top33;

/**
 * @author plusman
 * @since 2021/7/3 4:09 PM
 */
public class Top33Class implements Top33Solution {
    @Override
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        int mid;
        while (end >= start) {
            mid = start + (end -start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (target < nums[mid]) {
                // ascending part
                if ((nums[start] < nums[mid] && target >= nums[start]) ||
                    nums[start] > nums[mid]
                ) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if ((nums[mid] < nums[end] && target <= nums[end]) ||
                    nums[mid] > nums[end]
                ) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            
        }
        
        return -1;
    }
}
