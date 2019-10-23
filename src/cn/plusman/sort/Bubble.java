package cn.plusman.sort;

import java.util.Arrays;

public class Bubble {
    static int[] sort(int[] a) {
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
