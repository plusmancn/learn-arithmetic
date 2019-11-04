package cn.plusman.search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Search1 {

    /**
     * 查找第一个值等于给定值的元素
     */
    public static int searchAhead(int[] a, int key) {
        int low = 0;
        int high = a.length -1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) >>> 1;

            if(a[mid] == key) {
                if(mid != 0 && a[mid -1] == key) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if(a[mid] > key) {
                high = mid - 1;
            } else if(a[mid] < key) {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public static int searchBackwards(int[] a, int key) {
        int low = 0;
        int high = a.length -1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) >>> 1;

            if(a[mid] == key) {
                if(mid != a.length - 1 && a[mid + 1] == key) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else if(a[mid] > key) {
                high = mid - 1;
            } else if(a[mid] < key) {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */

    /**
     * 查找最后一个小于等于给定值的元素
     */



    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 8, 8, 8, 8, 10};
        System.out.println("searchAhead: " + searchAhead(a, 8));
        System.out.println("searchBackwards: " + searchBackwards(a, 8));
        System.out.println("binarySearch：" + Arrays.binarySearch(a, 8));

        
    }
}
