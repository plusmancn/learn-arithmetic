/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.backtracking;

import java.util.Arrays;

/**
 * 0-1 背包改造
 * 如果每个物品不仅重量不同，价值也不同。如何在不超过背包重量的情况下，让背包中的总价值最大？
 * @author plusman
 * @since 2021/2/6 10:41 PM
 */
public class Bag01Value {
    int[] goodsWeight = new int[]{10, 8, 30, 23, 10};
    int[] goodsValue = new int[]{20, 15, 50, 20, 15};
    int maxValue = Integer.MIN_VALUE;
    int[] bestPlan = new int[5];
    
    /**
     * 取物品
     * @param i 第几轮取物
     * @param cw 当前重量
     * @param cv 当前价值
     * @param cBag 当前背包
     */
    private void take(int i, int cw, int cv, int limitValue, int [] cBag) {
        if(cw == limitValue || i == goodsWeight.length) {
            if (cv > maxValue) {
                bestPlan = cBag;
                maxValue = cv;
            }
            return;
        }
        
        // 没放进去
        int[] notPutIn = cBag.clone();
        notPutIn[i] = 0;
        take(i + 1, cw, cv, limitValue, notPutIn);
        // 放进去了
        if (cw + goodsWeight[i] <= limitValue) {
            int[] putIn = cBag.clone();
            putIn[i] = 1;
            take(i + 1, cw + goodsWeight[i], cv + goodsValue[i], limitValue, putIn);
        }
    }
    
    public static void main(String[] args) {
        Bag01Value bag01Value = new Bag01Value();
        
        
        bag01Value.take(0, 0, 0, 30, new int[5]);
        System.out.println(bag01Value.maxValue);
        System.out.println(Arrays.toString(bag01Value.bestPlan));
    }
}
