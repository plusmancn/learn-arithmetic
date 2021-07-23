package cn.plusman.arithmetic.leetcode.top.top116;

import cn.plusman.arithmetic.leetcode.top.Node;

/**
 * Using constant extra sapce
 * @author plusman
 * @since 2021/7/23 5:15 PM
 */
public class Top116O1Class implements Top116Solution {
    @Override
    public Node connect(Node root) {
        Node nextLineRoot = root;
        while (nextLineRoot != null) {
            Node nextNode = nextLineRoot;
            while (nextNode != null) {
                if (nextNode.left == null) {
                    return root;
                }
                nextNode.left.next = nextNode.right;
                if (nextNode.next != null) {
                    nextNode.right.next = nextNode.next.left;
                }
                nextNode = nextNode.next;
            }
            nextLineRoot = nextLineRoot.left;
        }
        
        return root;
    }
}
