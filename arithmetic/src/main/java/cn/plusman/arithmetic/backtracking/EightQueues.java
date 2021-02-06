/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.backtracking;

/**
 * 八皇后问题
 * @author plusman
 * @since 2021/2/6 9:00 PM
 */
public class EightQueues {
    /**
     * 数组下标代表 row，值代表 column
     */
    private int[] results = new int[8];
    private int count = 0;
    
    
    private void gen8Queues(int row) {
        if (row == 8) {
            printQueues();
            return;
        }
        
        for (int column = 0; column < 8; column++) {
            if (isOK(row, column)) {
                results[row] = column;
                gen8Queues(row + 1);
            }
        }
    }
    
    
    private boolean isOK(int row, int column) {
        // 向上回溯
        int left = column - 1, right = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (results[i] == column || results[i] == left || results[i] == right) {
                return false;
            }
            
            left--;
            right++;
        }
        
        return true;
    }
    
    private void printQueues() {
        System.out.println("Find " + ++count);
        
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < 8; j++) {
                if(results[i] == j) {
                    System.out.print("Q  ");
                } else {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        EightQueues eightQueues = new EightQueues();
        eightQueues.gen8Queues(0);
    }
}
