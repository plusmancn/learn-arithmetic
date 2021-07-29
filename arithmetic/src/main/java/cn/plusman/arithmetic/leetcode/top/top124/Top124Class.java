package cn.plusman.arithmetic.leetcode.top.top124;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author plusman
 * @since 2021/7/28 5:59 PM
 */
public class Top124Class implements Top124Solution {
    @Override
    public int maxPathSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        Deque<TreeNode> deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // add element to deque ascending level
        while (!queue.isEmpty()) {
            deque.addAll(queue);
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
        // travel in descending level
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            // As Root
            int rootSum = node.val, leftValue = 0, rightValue = 0;
            if (node.left != null && node.left.val > 0) {
                rootSum += node.left.val;
                leftValue = node.left.val;
            }
            if (node.right != null && node.right.val > 0) {
                rootSum += node.right.val;
                rightValue = node.right.val;
            }
            
            // As normal
            node.val += Math.max(leftValue, rightValue);
            
            if (rootSum > maxSum) {
                maxSum = rootSum;
            }
        }
        
        return maxSum;
    }
}
