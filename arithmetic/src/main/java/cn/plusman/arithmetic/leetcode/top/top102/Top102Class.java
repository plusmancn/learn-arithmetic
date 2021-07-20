package cn.plusman.arithmetic.leetcode.top.top102;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

import java.util.*;

/**
 * @author plusman
 * @since 2021/7/20 9:54 PM
 */
public class Top102Class implements Top102Solution {
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> rtnList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int curlevelSize = queue.size();
            for (int i = 0; i < curlevelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            rtnList.add(list);
        }
        
        return rtnList;
    }
}
