package cn.plusman.tree;

import static org.junit.jupiter.api.Assertions.*;

class  LevelOrderTraversalTest{

    @org.junit.jupiter.api.Test
    void levelOrder() {
        TreeNode root = new TreeNode(3);
        TreeNode e1 = new TreeNode(9);
        TreeNode e2 = new TreeNode(20);
        TreeNode e4 = new TreeNode(15);
        TreeNode e5 = new TreeNode(7);

        root.left = e1;
        root.right= e2;
        e2.left = e4;
        e2.right = e5;

        LevelOrderTraversal bfs = new LevelOrderTraversal();
        System.out.println(bfs.levelOrder(root));
    }
}