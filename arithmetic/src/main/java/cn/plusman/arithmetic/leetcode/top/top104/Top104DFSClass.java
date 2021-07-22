package cn.plusman.arithmetic.leetcode.top.top104;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

/**
 * @author plusman
 * @since 2021/7/21 12:07 PM
 */
public class Top104DFSClass implements Top104Solution{
    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return Math.max(
            maxDepth(root.left),
            maxDepth(root.right)
        ) + 1;
    }
}
