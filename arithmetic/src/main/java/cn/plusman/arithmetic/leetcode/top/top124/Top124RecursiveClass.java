package cn.plusman.arithmetic.leetcode.top.top124;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

/**
 * @author plusman
 * @since 2021/7/28 9:03 PM
 */
public class Top124RecursiveClass implements Top124Solution {
    private int maxSum;
    
    @Override
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }
    
    int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int rootSum, leftValue = 0, rightValue = 0;
        leftValue = maxGain(node.left);
        rightValue = maxGain(node.right);
    
        // As Root
        rootSum = leftValue + rightValue + node.val;
        
        if (rootSum > maxSum) {
            maxSum = rootSum;
        }
        
        // As normal
        node.val += Math.max(leftValue, rightValue);
        
        return node.val < 0 ? 0 : node.val;
    }
}
