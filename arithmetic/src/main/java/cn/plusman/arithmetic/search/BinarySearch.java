package cn.plusman.arithmetic.search;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] a, int key) {
        return searchC(a, key, 0, a.length - 1);
    }

    public static int searchC(int[] a, int key, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = (low + high) >>> 1;
        int midVal = a[mid];

        if(midVal > key) {
            return searchC(a, key, low, high -1);
        } else if(midVal < key) {
            return searchC(a, key, low + 1, high);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Arrays.binarySearch(a, 3);

        System.out.println(search(a, 3));
        System.out.println(search(a, -1));
    }
}
