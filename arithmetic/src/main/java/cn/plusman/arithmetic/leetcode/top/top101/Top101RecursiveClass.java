package cn.plusman.arithmetic.leetcode.top.top101;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

/**
 * @author plusman
 * @since 2021/7/20 11:57 AM
 */
public class Top101RecursiveClass implements Top101Solution {
    @Override
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    
    private boolean check(TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            if (l != r) {
                return false;
            }
            return true;
        } else {
            return l.val == r.val ? check(l.left, r.right) && check(l.right, r.left): false;
        }
    }
}
