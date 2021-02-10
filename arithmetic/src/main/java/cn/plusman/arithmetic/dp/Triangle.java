/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 三角最短路径求和问题
 * @author plusman
 * @since 2021/2/10 9:05 AM
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] valueArr = new int[2][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            int currentLevel = i % 2;
            int preLevel = (i + 1) % 2;
            
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    valueArr[currentLevel][j] = valueArr[preLevel][j] + triangle.get(i).get(j);
                } else if (j == (triangle.get(i).size() - 1)) {
                    valueArr[currentLevel][j] = valueArr[preLevel][j - 1] + triangle.get(i).get(j);
                } else {
                    valueArr[currentLevel][j] = Math.min(
                        valueArr[preLevel][j - 1],
                        valueArr[preLevel][j]
                    ) + triangle.get(i).get(j);
                }
            }
        }
        
        int currentLevel = (triangle.size() - 1) % 2;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < valueArr[currentLevel].length; i++) {
            if (valueArr[currentLevel][i] < minValue) {
                minValue = valueArr[currentLevel][i];
            }
        }
        
        return minValue;
    }
    
    public static void main(String[] args) {
        Triangle t = new Triangle();
        
        /**
         * 初始化三角值
         *    2
         *   3 4
         *  6 5 7
         * 4 1 8 3
         */
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8 ,3)
        );

        System.out.println(t.minimumTotal(triangle));
    
    
        /**
         *   1
         * 2   3
         */
        List<List<Integer>> triangle1 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2, 3)
        );
        System.out.println(t.minimumTotal(triangle1));
    }
}
