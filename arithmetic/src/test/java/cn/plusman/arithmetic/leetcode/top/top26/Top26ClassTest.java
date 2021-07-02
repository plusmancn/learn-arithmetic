package cn.plusman.arithmetic.leetcode.top.top26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/2 11:21 PM
 */
class Top26ClassTest {
    Top26Solution top26Solution = new Top26Class();
    
    @Test
    void removeDuplicates() {
        int result;
        
        int[] input1 = new int[]{1,1,2};
        result = top26Solution.removeDuplicates(input1);
        System.out.println(input1);
        System.out.println(result);
    }
}