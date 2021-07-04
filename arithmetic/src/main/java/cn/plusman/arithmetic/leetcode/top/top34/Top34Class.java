package cn.plusman.arithmetic.leetcode.top.top34;

/**
 * @author plusman
 * @since 2021/7/3 8:31 PM
 */
public class Top34Class implements Top34Solution {
    @Override
    public int[] searchRange(int[] nums, int target) {
        int[] result = search(nums, target, 0, nums.length - 1);
        if (result[0] == -1) {
            return new int[]{-1, -1};
        }
        
        // find right edge
        int re = result[0];
        int rEnd = result[2];
        while (true) {
            int[] resR = search(nums, target, re + 1, rEnd);
            if (resR[0] != -1) {
                re = resR[0];
                rEnd = resR[2];
            } else {
                break;
            }
        }
        
        // find left edge
        int le = result[0];
        int lStart = result[1];
        while (true) {
            int[] resL = search(nums, target, lStart, le - 1);
            if (resL[0] != -1) {
                le = resL[0];
                lStart = resL[1];
            } else {
                break;
            }
        }
        
        return new int[]{le, re};
    }
    
    private int[] search(int[] nums, int target, int start, int end) {
        while (end >= start) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return new int[]{mid, start, end};
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return new int[]{-1, start, end};
    }
}
