package cn.plusman.arithmetic.leetcode.top.top75;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author plusman
 * @since 2021/7/15 5:38 PM
 */
class Top75ClassTest {
    Top75Solution top75Solution = new Top75Class();
    
    @Test
    void sortColors() {
        int[] input; 
        
        input = new int[]{2,0,2,1,1,0};
        top75Solution.sortColors(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{2,0,1};
        top75Solution.sortColors(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{0};
        top75Solution.sortColors(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{1};
        top75Solution.sortColors(input);
        System.out.println(Arrays.toString(input));
    
        input = new int[]{0,0};
        top75Solution.sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}