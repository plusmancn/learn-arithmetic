package cn.plusman.sort;

import java.util.Arrays;

public class Bubble {
    static void sort(int[] a) {
        if(a.length == 1) return;

        for(int i = 0; i < a.length; i++) {
            boolean inOrder = true;
            for(int j = 0; j < a.length - i - 1; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;

                    inOrder = false;
                }
            }

            if(inOrder) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
