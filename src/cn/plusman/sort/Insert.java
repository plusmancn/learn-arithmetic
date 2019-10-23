package cn.plusman.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Insert {
    static int[] sort(int[] a) {
        if(a.length <= 1) return a;

        for(int i = 1; i < a.length; i++) {
            int temp = a[i];

            int j = i - 1;
            for(; j >= 0; j--) {
                if(a[j] > temp) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }

            a[j+1] = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
