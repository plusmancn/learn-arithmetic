package cn.plusman.arithmetic.leetcode.top.top105;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

import java.util.*;

/**
 * @author plusman
 * @since 2021/7/22 12:04 AM
 */
public class Top105Class implements Top105Solution {
    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // <value, pos>
        Map<Integer, Integer> posInorder = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            posInorder.put(inorder[i], i);
        }
        
        return buildTree(
            preorder, 0, preorder.length - 1,
            0, inorder.length - 1, 
            posInorder
        );
        
    }
    
    protected TreeNode buildTree(int[] preorder, int m, int n, int p, int q, Map<Integer, Integer> posInorder) {
        if ( m > n) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[m]);
        int inorderRootPos = posInorder.get(root.val);
        
        int leftPartLength = inorderRootPos - p;
        root.left = buildTree(
            preorder, m + 1, m + leftPartLength,
            inorderRootPos - leftPartLength, inorderRootPos - 1,
            posInorder
        );
        
        int rightPartLength = q - inorderRootPos;
        root.right = buildTree(
            preorder, m + leftPartLength + 1, m + leftPartLength + rightPartLength,
            inorderRootPos + 1, inorderRootPos + rightPartLength,
            posInorder
        );
        
        return root;
    }
}
