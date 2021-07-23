package cn.plusman.arithmetic.leetcode.top.top108;

import cn.plusman.arithmetic.leetcode.top.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/23 1:15 PM
 */
class Top108ClassTest {
    Top108Solution top108Solution = new Top108Class();
    
    @Test
    void sortedArrayToBST() {
        TreeNode result;
        
        result = top108Solution.sortedArrayToBST(new int[]{
            -10,-3,0,5,9
        });
        System.out.println(result);
    }
}