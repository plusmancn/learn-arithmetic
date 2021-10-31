package cn.plusman.arithmetic.leetcode.offer.offer40;

import java.util.ArrayList;

/**
 * @author plusman
 * @since 2021/10/31 11:30 PM
 */
public class Offer40Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        quickSort(input, 0, input.length - 1, k);
        
        ArrayList<Integer> list = new ArrayList(k);
        
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        
        return list;
    }
    
    private void quickSort(int[] input, int p, int r, int inK) {
        if (p < r) {
            int k = partition(input, p, r);
            
            if (k + 1 == inK) {
                return;
            } else if (k + 1 > inK) {
                quickSort(input, p, k - 1, inK);
            } else {
                quickSort(input, k + 1, r, inK);
            }
        }
    }
    
    private int partition(int[] input, int p, int r) {
        int pivot = input[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (input[j] < pivot) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, i, r);
        
        return i;
    }
    
    private void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}