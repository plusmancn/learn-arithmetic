package cn.plusman.sort;

import java.util.Arrays;

public class MergeSort {
    static void sort(int[] a) {
        sortC(a, 0, a.length -1);
    }

    static void sortC(int[] a, int p, int r) {
        if(p >= r) return;

        int q = (r + p) / 2;

        sortC(a, p ,q);
        sortC(a, q + 1, r);
        merge(a, p, q, r);
    }

    static void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;

        while (true) {
            if(a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }

            if(i > q || j > r) {
                break;
            }
        }

        // 判断哪个数组还有空余
        int start, end;
        if(i > q) {
            start = j;
            end = r;
        } else {
            start = i;
            end = q;
        }


        // 将剩余数组赋值
        for(; start <= end; start++) {
            tmp[k++] = a[start];
        }

        // 将临时数组赋值回原数组
        for(k = 0; k < tmp.length; k++) {
            a[p++] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 8, 39, 7, 1, 5, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {9, 2, 10, 7, 8, 2};
        System.out.println(Arrays.toString(arr2));
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
