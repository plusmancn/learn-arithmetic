/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.dp;

/**
 * @author plusman
 * @since 2021/2/17 8:59 PM
 */
public class LongestAscNumberLength {
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if(size == 0) {
            return 0;
        }
    
        int[] dp = new int[size];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < size; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
    
        return maxLength;
    }
    
    public static void main(String[] args) {
        LongestAscNumberLength longestAscNumberLength = new LongestAscNumberLength();
    
        // 4
        System.out.println(longestAscNumberLength.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        // 3
        System.out.println(longestAscNumberLength.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
