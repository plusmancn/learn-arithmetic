package cn.plusman.arithmetic.leetcode.top.top105;

import cn.plusman.arithmetic.leetcode.top.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/22 12:04 AM
 */
class Top105ClassTest {
    Top105Solution top105Solution = new Top105Class();
    
    @Test
    void buildTree() {
        
        TreeNode treeNode;
            
        treeNode = top105Solution.buildTree(
            new int[]{3,9,20,15,7},
            new int[]{9,3,15,20,7}
        );
        System.out.println(treeNode);

        treeNode = top105Solution.buildTree(
            new int[]{1,2},
            new int[]{1,2}
        );
        System.out.println(treeNode);

        treeNode = top105Solution.buildTree(
            new int[]{3,1,5,2,4},
            new int[]{5,1,2,3,4}
        );
        System.out.println(treeNode);
    
        treeNode = top105Solution.buildTree(
            new int[]{3,2,1,4},
            new int[]{1,2,3,4}
        );
        System.out.println(treeNode);
    }
}