package cn.plusman.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDepthOfBinaryTreeTest {
    private static TreeNode TreeNodeRoot;
    private static MaxDepthOfBinaryTree ins = new MaxDepthOfBinaryTree();

    @BeforeAll
    static void initAll() {
        TreeNodeRoot = new TreeNode(3);
        TreeNode e1 = new TreeNode(9);
        TreeNode e2 = new TreeNode(20);
        TreeNode e4 = new TreeNode(15);
        TreeNode e5 = new TreeNode(7);

        TreeNodeRoot.left = e1;
        TreeNodeRoot.right= e2;
        e2.left = e4;
        e2.right = e5;
    }

    @Test
    void maxDepth() {
        System.out.println(ins.maxDepth(TreeNodeRoot));
    }

    @Test
    void maxDepthV2() {
        System.out.println(ins.maxDepthV2(TreeNodeRoot));
    }
}