package cn.plusman.arithmetic.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
    // 利用广度优先，按层遍历的转换版本
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode element = queue.poll();
                if(element.left != null) queue.offer(element.left);
                if(element.right != null) queue.offer(element.right);
            }

            maxDepth++;
        }

        return maxDepth;
    }

    // 利用深度优先，分别求左右子树的高度
    public int maxDepthV2(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxDepthV2(root.left), maxDepthV2(root.right));
    }
}
