package cn.plusman.arithmetic.leetcode.top.top19;

import cn.plusman.arithmetic.leetcode.top.ListNode;

/**
 * @author plusman
 * @since 2021/7/2 2:44 PM
 */
public class Top19Class implements Top19Solution {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = null;
        ListNode fast = head;
        // offset
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        
        while (fast != null && (fast = fast.next) != null) {
            if (slow == null) {
                slow = head;
            } else {
                slow = slow.next;
            }
        }
        
        if (slow == null) {
            return head.next;
        } else {
            slow.next = slow.next.next;
        }
        
        return head;
    }
}
