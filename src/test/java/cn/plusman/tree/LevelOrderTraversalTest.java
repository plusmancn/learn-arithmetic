package cn.plusman.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class  LevelOrderTraversalTest{
    static TreeNode TreeNodeRoot;

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

    @org.junit.jupiter.api.Test
    void levelOrder() {


        LevelOrderTraversal bfs = new LevelOrderTraversal();
        System.out.println(bfs.levelOrder(TreeNodeRoot));
    }

    @Test
    void levelOrderOfficial() {
        LevelOrderTraversal bfs = new LevelOrderTraversal();
        System.out.println(bfs.levelOrderOfficial(TreeNodeRoot));
    }
}