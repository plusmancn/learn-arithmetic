package cn.plusman.arithmetic.leetcode.top.top88;

import java.util.Arrays;

/**
 * @author plusman
 * @since 2021/7/18 9:00 PM
 */
public class Top88Class implements Top88Solution {
    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] c1 = Arrays.copyOf(nums1, m);
       
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if(i == m) {
                nums1[k++] = nums2[j++]; 
            } else if (j == n) {
                nums1[k++] = c1[i++];
            } else {
                nums1[k++] = c1[i] < nums2[j] ? c1[i++] : nums2[j++];
            }
        }
    }
}
