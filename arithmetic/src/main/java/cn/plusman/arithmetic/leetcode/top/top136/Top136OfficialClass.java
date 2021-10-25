package cn.plusman.arithmetic.leetcode.top.top136;

/**
 * @author plusman
 * @since 2021/10/25 12:56 PM
 */
public class Top136OfficialClass implements Top136Solution {
    @Override
    public int singleNumber(int[] nums) {
       int result = 0;
       
       for (int i = 0; i < nums.length; i++) {
           result ^= nums[i];
       }
       
       return result;
    }
}
