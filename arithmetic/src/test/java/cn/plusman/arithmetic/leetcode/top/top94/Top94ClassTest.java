package cn.plusman.arithmetic.leetcode.top.top94;

import cn.plusman.arithmetic.leetcode.top.TreeNode;
import cn.plusman.arithmetic.leetcode.top.TreeNodeGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/19 9:15 AM
 */
class Top94ClassTest {
    Top94Solution top94Solution = new Top94Class();
    
    @Test
    void inorderTraversal() {
        TreeNode root;
        List<Integer> result;
        
        root = TreeNodeGenerator.fromList(Arrays.asList(
           1, null, 2, 3 
        ));
        result = top94Solution.inorderTraversal(root);
        System.out.println(result);
    }
}