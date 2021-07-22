package cn.plusman.arithmetic.leetcode.top.top104;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author plusman
 * @since 2021/7/21 11:59 AM
 */
public class Top104Class implements Top104Solution {
    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
    
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return count;
    }
}
