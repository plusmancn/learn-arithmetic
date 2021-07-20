package cn.plusman.arithmetic.leetcode.top.top98;

import cn.plusman.arithmetic.leetcode.top.TreeNode;
import cn.plusman.arithmetic.leetcode.top.TreeNodeGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/19 7:31 PM
 */
class Top98ClassTest {
    Top98Solution top98Solution = new Top98Class();
    
    @Test
    void isValidBST() {
        boolean result;
    
        result = top98Solution.isValidBST(TreeNodeGenerator.fromList(Arrays.asList(
            0
        )));
        Assertions.assertEquals(true, result);
        
        result = top98Solution.isValidBST(TreeNodeGenerator.fromList(Arrays.asList(
            2,1,3
        )));
        Assertions.assertEquals(true, result);

        result = top98Solution.isValidBST(TreeNodeGenerator.fromList(Arrays.asList(
            5,1,4,null,null,3,6
        )));
        Assertions.assertEquals(false, result);
    
        result = top98Solution.isValidBST(TreeNodeGenerator.fromList(Arrays.asList(
            5,4,6,null,null,3,7
        )));
        Assertions.assertEquals(false, result);
        
    }
}