package cn.plusman.arithmetic.leetcode.top.top23;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;
import cn.plusman.arithmetic.leetcode.top.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/2 10:36 PM
 */
class Top23ClassTest {
    Top23Solution top23Solution = new Top23Class();
    
    @Test
    void mergeKLists() {
        ListNode head;
        
        head = top23Solution.mergeKLists(new ListNode[] {
            InspectUtil.initLinkedList(new int[]{1,4,5}),
            InspectUtil.initLinkedList(new int[]{1,3,4}),
            InspectUtil.initLinkedList(new int[]{2,6}),
        });
        InspectUtil.displayLinkedList(head);
    
        head = top23Solution.mergeKLists(new ListNode[] {});
        InspectUtil.displayLinkedList(head);
    }
}