package cn.plusman.arithmetic.leetcode.top.top103;

import cn.plusman.arithmetic.leetcode.top.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author plusman
 * @since 2021/7/21 12:13 AM
 */
public class Top103Class implements Top103Solution {
    @Override
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
    
        List<List<Integer>> rtnList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
    
        queue.offer(root);
        int order = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int curlevelSize = queue.size();
            for (int i = 0; i < curlevelSize; i++) {
                TreeNode node = queue.poll();
                if (order % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            rtnList.add(list);
            order++;
        }
    
        return rtnList;
    }
}
