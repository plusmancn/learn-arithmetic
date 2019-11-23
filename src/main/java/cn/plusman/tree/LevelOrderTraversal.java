package cn.plusman.tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LevelOrderTraversal {
    static public class TreeNodeWithLevel {
        int level;
        TreeNode node;

        TreeNodeWithLevel(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rtn = new LinkedList<>();
        if (root == null) return rtn;

        int curLevel = 1; // 当前层级
        Queue<TreeNodeWithLevel> qt = new LinkedList<>();
        qt.offer(new TreeNodeWithLevel(curLevel, root));

        List<Integer> listLevel = new LinkedList<>();

        while (!qt.isEmpty()) {
            TreeNodeWithLevel element = qt.poll();

            if(element.level == curLevel) {
                listLevel.add(element.node.val);
            } else {
                rtn.add(listLevel);
                curLevel++;
                listLevel = new LinkedList<>();
                listLevel.add(element.node.val);
            }

            if(element.node.left != null) qt.offer(new TreeNodeWithLevel(
                    element.level + 1,
                    element.node.left
            ));
            if(element.node.right != null) qt.offer(new TreeNodeWithLevel(
                    element.level + 1,
                    element.node.right
            ));
        }

        // 末层 Level 添加
        rtn.add(listLevel);

        return rtn;
    }
}
