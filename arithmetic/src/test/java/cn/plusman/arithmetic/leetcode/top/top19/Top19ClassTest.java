package cn.plusman.arithmetic.leetcode.top.top19;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;
import cn.plusman.arithmetic.leetcode.top.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * For Test
 * @author plusman
 * @since 2021/7/2 2:44 PM
 */
class Top19ClassTest {
    Top19Solution top19Solution = new Top19Class();
    
    @Test
    void removeNthFromEnd() {
        ListNode head;
        
        head = top19Solution.removeNthFromEnd(
            InspectUtil.initLinkedList(new int[]{
                1,2
            }),
            1
        );
        InspectUtil.displayLinkedList(head);
    
        head = top19Solution.removeNthFromEnd(
            InspectUtil.initLinkedList(new int[]{
                1,2,3,4,5
            }),
            2
        );
        InspectUtil.displayLinkedList(head);
    
        head = top19Solution.removeNthFromEnd(
            InspectUtil.initLinkedList(new int[]{
                1
            }),
            1
        );
        InspectUtil.displayLinkedList(head);
    
    }
}