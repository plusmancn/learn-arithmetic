package cn.plusman.arithmetic.leetcode.top.top98;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

import java.util.Stack;

/**
 * @author plusman
 * @since 2021/7/19 7:31 PM
 */
public class Top98Class implements Top98Solution {
    @Override
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long maxValue = Long.MIN_VALUE;
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            TreeNode node = stack.pop();
            if (maxValue >= node.val ) {
                return false;
            } else {
                maxValue = node.val;
            }
            root = node.right;
        }
        
        return true;
    }
}
