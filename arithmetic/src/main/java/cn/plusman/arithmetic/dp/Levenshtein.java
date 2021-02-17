/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.arithmetic.dp;

/**
 * @author plusman
 * @since 2021/2/16 9:34 PM
 */
public class Levenshtein {
    
    public int minDistance(String word1, String word2) {
        // 空字符串处理
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        
        // 最短路径表
        int minDest[][] = new int[word1.length()][word2.length()];
        
        if (word1.charAt(0) == word2.charAt(0)) {
            minDest[0][0] = 0;
        } else {
            minDest[0][0] = 1;
        }
        
        // 初始化行首
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                minDest[i][0] = i;
                for (i++; i < word1.length(); i++) {
                    minDest[i][0] = i;
                }
            } else {
                minDest[i][0] = i + 1;
            }
        }
        
        for (int j = 0; j < word2.length(); j++) {
            if (word2.charAt(j) == word1.charAt(0)) {
                minDest[0][j] = j;
                for (j++; j < word2.length(); j++) {
                    minDest[0][j] = j;
                }
            } else {
                minDest[0][j] = j + 1;
            }
        }
        
        // 按行填充
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if(word1.charAt(i) != word2.charAt(j)) {
                    minDest[i][j] = minTriple(minDest[i-1][j], minDest[i][j-1], minDest[i-1][j-1]) + 1;
                }
                
                if (word1.charAt(i) == word2.charAt(j)) {
                    minDest[i][j] = minTriple(minDest[i-1][j] + 1, minDest[i][j-1] + 1, minDest[i-1][j-1]);
                }
            }
        }
        
        return minDest[word1.length() -1][word2.length() -1];
    }
    
    private int minTriple(int x, int y, int z) {
        int minValue = Integer.MAX_VALUE;
        if (x < minValue) {
            minValue = x;
        }
        
        if (y < minValue) {
            minValue = y;
        }
        
        if (z < minValue) {
            minValue = z;
        }
        
        return minValue;
    }
    
    public static void main(String[] args) {
        Levenshtein levenshtein = new Levenshtein();
        
        // 3
        System.out.println(levenshtein.minDistance("mitcmu", "mtacnu"));
        // 5
        System.out.println(levenshtein.minDistance("intention", "execution"));
        // 2
        System.out.println(levenshtein.minDistance("sea", "eat"));
        // 27
        System.out.println(levenshtein.minDistance(
            "pneumonoultramicroscopicsilicovolcanoconiosis",
            "ultramicroscopically"
        ));
    }
}
