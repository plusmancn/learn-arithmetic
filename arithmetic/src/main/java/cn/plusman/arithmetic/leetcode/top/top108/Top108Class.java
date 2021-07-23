package cn.plusman.arithmetic.leetcode.top.top108;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

/**
 * @author plusman
 * @since 2021/7/23 1:07 PM
 */
public class Top108Class implements Top108Solution {
    
    @Override
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildMyBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildMyBST(int[] nums, int m, int n) {
        if (m > n) {
            return null;
        }
        
        int midPos = (m + n) / 2;
        TreeNode root = new TreeNode(nums[midPos]);
        
        root.left = buildMyBST(nums, m, midPos - 1);
        root.right = buildMyBST(nums, midPos + 1, n);
        
        return root;
    }
}
