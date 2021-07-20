package cn.plusman.arithmetic.leetcode.top.top88;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/18 9:03 PM
 */
class Top88ClassTest {
    // Top88Solution top88Solution = new Top88Class();
    Top88Solution top88Solution = new Top88O1Class();
    
    @Test
    void merge() {
        int[] nums1;
        
        nums1 = new int[]{1,2,3,0,0,0};
        top88Solution.merge(nums1, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(nums1));
    }
}