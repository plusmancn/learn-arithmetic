package cn.plusman.arithmetic.leetcode.top.top116;

import cn.plusman.arithmetic.leetcode.top.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author plusman
 * @since 2021/7/23 2:21 PM
 */
public class Top116Class implements Top116Solution {
    @Override
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                Node node = queue.poll();
                if (i + 1 < curSize) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return root;
    }
}
