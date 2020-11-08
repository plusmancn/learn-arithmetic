package cn.plusman.arithmetic.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DFSTraversalTest {
    private static TreeNode TreeNodeRoot;
    private static DFSTraversal ins = new DFSTraversal();

    @BeforeAll
    static void initAll() {
        /**
         *      1
         *   2     3
         * 4  5  6   7
         */

        TreeNodeRoot = new TreeNode(1);
        TreeNode e1 = new TreeNode(2);
        TreeNode e2 = new TreeNode(3);
        TreeNode e3 = new TreeNode(4);
        TreeNode e4 = new TreeNode(5);
        TreeNode e5 = new TreeNode(6);
        TreeNode e6 = new TreeNode(7);

        TreeNodeRoot.left = e1;
        TreeNodeRoot.right= e2;
        e1.left = e3;
        e1.right = e4;
        e2.left = e5;
        e2.right = e6;
    }

    @Test
    void stackVersion() {
        System.out.println(ins.stackVersion(TreeNodeRoot));
    }

    @Test
    void recursionVersion() {
        ins.recursionVersion(TreeNodeRoot);
    }
}