package cn.plusman.arithmetic.sort;

import java.util.Arrays;

public class QuickSort {
    static void sort(int[] a) {
        sortC(a, 0, a.length -1);
    }

    static void sortC(int[] a, int p, int r) {
        if(p >= r) return;

        int q = partition(a, p, r);
        sortC(a, p, q -1);
        sortC(a, q+1, r);
    }

    static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = i; j < r; j++) {
            if(a[j] < pivot) {
                int tmp = a[i];
                a[i++] = a[j];
                a[j] = tmp;
            }
        }

        a[r] = a[i];
        a[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 8, 39, 7, 1, 5, 2};
        System.out.println(Arrays.toString(arr1));
        sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {9, 2, 10, 7, 8, 2};
        System.out.println(Arrays.toString(arr2));
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
