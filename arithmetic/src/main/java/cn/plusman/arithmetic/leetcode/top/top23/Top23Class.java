package cn.plusman.arithmetic.leetcode.top.top23;

import cn.plusman.arithmetic.leetcode.top.ListNode;

import java.util.Arrays;

/**
 * @author plusman
 * @since 2021/7/2 10:35 PM
 */
public class Top23Class implements Top23Solution {
    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = Arrays.stream(lists).reduce(null, (pre, now) -> mergeTwoLists(pre, now));
        return listNode;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode();
        ListNode pre = sentry;
        while (l1 != null || l2 != null) {
            if(l1 == null) {
                pre.next = l2;
                break;
            } else if (l2 == null) {
                pre.next = l1;
                break;
            } else {
                if (l1.val < l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                    pre = pre.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                    pre = pre.next;
                }
            }
        }
        
        return sentry.next;
    }
}
