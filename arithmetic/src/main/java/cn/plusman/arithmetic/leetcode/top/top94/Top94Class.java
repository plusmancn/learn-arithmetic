package cn.plusman.arithmetic.leetcode.top.top94;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/19 9:10 AM
 */
public class Top94Class implements Top94Solution {
    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rtnList = new ArrayList<>();
        inorderTraversal(root, rtnList);
        return rtnList;
    }
    
    protected void inorderTraversal(TreeNode node, List<Integer> rtnList) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left, rtnList);
        rtnList.add(node.val);
        inorderTraversal(node.right, rtnList);
    }
}
