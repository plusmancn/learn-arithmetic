package cn.plusman.arithmetic.leetcode.offer.offer40;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/10/31 11:31 PM
 */
class Offer40SolutionTest {
    Offer40Solution offer40Solution = new Offer40Solution();
    
    @Test
    void getLeastNumbers_Solution() {
        List<Integer> result = offer40Solution.GetLeastNumbers_Solution(
            new int[]{4,5,1,6,2,7,3,8},
            4
        );
        System.out.println(result);
    }
}