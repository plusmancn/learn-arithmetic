package cn.plusman.arithmetic.leetcode.top.top101;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author plusman
 * @since 2021/7/20 9:45 AM
 */
public class Top101Class implements Top101Solution {
    @Override
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> inorderList = new ArrayList<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                root = stack.pop();
                inorderList.add(root.left);
                inorderList.add(root.right);
            }
            
            int midN = inorderList.size() / 2;
            for (int i = 1; midN - i >= 0; i++) {
                TreeNode left = inorderList.get(midN - i);
                TreeNode right = inorderList.get(midN + i -1);
                
                if (left == null || right == null) {
                    if (left != right) {
                        return false;
                    }
                } else if (left.val != right.val) {
                    return false;
                }
            }
    
            for (TreeNode treeNode : inorderList) {
                if (treeNode != null) {
                    stack.push(treeNode);
                }
            }
            inorderList.clear();
        }
    
        return true;
    }
}
