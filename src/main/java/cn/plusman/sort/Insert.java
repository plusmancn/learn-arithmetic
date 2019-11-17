package cn.plusman.sort;

import java.util.Arrays;

public class Insert {
    static void sort(int[] a) {
        if(a.length <= 1) return;

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

            // 存在原地赋值的情况
            a[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
