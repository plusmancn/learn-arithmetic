package cn.plusman.arithmetic.leetcode.top.top21;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;
import cn.plusman.arithmetic.leetcode.top.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author plusman
 * @since 2021/7/2 4:27 PM
 */
class Top21ClassTest {
    Top21Solution top21Solution = new Top21Class();
    
    @Test
    void mergeTwoLists() {
        ListNode head;
        
        head = top21Solution.mergeTwoLists(
            InspectUtil.initLinkedList(new int[]{1,2,4}),
            InspectUtil.initLinkedList(new int[]{1,3,4})
        );
        InspectUtil.displayLinkedList(head);
    
        head = top21Solution.mergeTwoLists(
            InspectUtil.initLinkedList(new int[]{}),
            InspectUtil.initLinkedList(new int[]{1,3,4})
        );
        InspectUtil.displayLinkedList(head);
    
        head = top21Solution.mergeTwoLists(
            InspectUtil.initLinkedList(new int[]{}),
            InspectUtil.initLinkedList(new int[]{})
        );
        InspectUtil.displayLinkedList(head);
    }
}