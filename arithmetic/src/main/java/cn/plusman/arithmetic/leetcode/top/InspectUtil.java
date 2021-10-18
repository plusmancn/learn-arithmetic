package cn.plusman.arithmetic.leetcode.top;

/**
 * For Data View
 * @author plusman
 * @since 2021/6/30 2:47 PM
 */
public class InspectUtil {
    /**
     * Mostly used in DP
     * @param arr
     */
    public static void showArray(boolean[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i > -1; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j] ? "1 " : "0 ");
            }
            sb.append("\n");
        }
    
        System.out.println(sb.toString());
    }
    
    public static void showArray(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
                sb.append(' ');
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public static void showArray(char[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
                sb.append(' ');
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    } 
    
    public static ListNode initLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            pre.next = node;
            pre = node;
        }
        
        return head;
    }
    
    public static void displayLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
