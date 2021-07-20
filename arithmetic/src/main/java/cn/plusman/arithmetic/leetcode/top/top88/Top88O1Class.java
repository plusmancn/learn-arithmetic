package cn.plusman.arithmetic.leetcode.top.top88;

/**
 * @author plusman
 * @since 2021/7/18 9:21 PM
 */
public class Top88O1Class implements Top88Solution {
    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int k = nums1.length - 1;
        
        while (p1 > -1 || p2 > -1) {
            if (p1 < 0) {
                nums1[k--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[k--] = nums1[p1--];
            } else {
                nums1[k--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            }
        }
    }
}
