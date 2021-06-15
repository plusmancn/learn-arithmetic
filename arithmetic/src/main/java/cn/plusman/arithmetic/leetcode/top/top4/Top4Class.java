package cn.plusman.arithmetic.leetcode.top.top4;

/**
 * @author plusman
 * @since 2021/6/9 10:46 PM
 */
public class Top4Class {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int totalLeftSize = (m + n +1) / 2;
        
        int leftMax = 0, rightMin = 0;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = totalLeftSize - i;
            
            int nums_im1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums_i = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums_jm1 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums_j = j == n ? Integer.MAX_VALUE : nums2[j];
            
            if (nums_im1 > nums_j) {
                right = i - 1;
            } else {
                leftMax = Math.max(nums_im1, nums_jm1);
                rightMin = Math.min(nums_i, nums_j);
                left = i + 1;
            }
        }
    
        if ((m + n) % 2 == 0) {
            return (leftMax + rightMin) / 2.0;
        } else {
            return leftMax;
        }
    }
}
