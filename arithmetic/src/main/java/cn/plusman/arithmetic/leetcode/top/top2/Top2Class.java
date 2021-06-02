package cn.plusman.arithmetic.leetcode.top.top2;

import cn.plusman.arithmetic.leetcode.top.ListNode;

/**
 * @author plusman
 * @since 2021/6/2 11:47 PM
 */
public class Top2Class {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(
            2,
            new ListNode(
                4,
                new ListNode(
                    3
                )
            )
        );
        
        ListNode l2 = new ListNode(
            5,
            new ListNode(
                6,
                new ListNode(
                    4
                )
            )
        );
        
        Top2Class top2Class = new Top2Class();
        
        ListNode r = top2Class.addTwoNumbers(l1, l2);
    
        do {
            System.out.print(r.val + " ");
        } while ((r = r.next) != null);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        
        ListNode current = head;
        for(;;) {
            int count = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + current.val;
            
            int Vdiv = count / 10;
            int Vmod = count % 10;
    
            current.val = Vmod;
            
            if (Vdiv > 0) {
                current.next = new ListNode(1);
            }
    
            
            Boolean l1Exists = l1 != null && (l1 = l1.next) != null;
            Boolean l2Exists = l2 != null && (l2 = l2.next) != null;
            
            if (!l1Exists && !l2Exists) {
                break;
            } else {
                current.next = current.next == null ? new ListNode(0) : current.next;
                current = current.next;
            }
        }
        
        return head;
    }
}
