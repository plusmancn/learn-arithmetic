package cn.plusman.arithmetic.leetcode.top.top79;

import java.util.*;

/**
 * @author plusman
 * @since 2021/7/17 5:40 PM
 */
public class Top79Class implements Top79Solution {
    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    @Override
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Set<Integer> thisVisited = new HashSet<>(word.length()); 
                if (trySearch(i, j, board, word, thisVisited, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    protected boolean trySearch(int x, int y, char[][] board, String word, Set<Integer> thisVisited, int k) {
        Integer curMark = getMark(x, y);
        // prevent duplicate visit
        thisVisited.add(curMark);
        
        char ch = word.charAt(k);
        if (board[x][y] == ch) {
            if (k == word.length() - 1) {
                return true;
            }
            
            int tmpX, tmpY;
            Integer tmpMark;
            for (int[] direction : directions) {
                tmpX = x + direction[0];
                tmpY = y + direction[1];
                tmpMark = getMark(tmpX, tmpY);
                
                if (tmpX > -1 && tmpX < board.length && tmpY > -1 && tmpY < board[0].length && board[tmpX][tmpY] == word.charAt(k + 1) && !thisVisited.contains(tmpMark)) {
                    if (trySearch(tmpX, tmpY, board, word, thisVisited, k + 1)) {
                        return true;
                    } else {
                        thisVisited.remove(tmpMark);
                    }
                }
            }
        }
        
        return false;
    }
    
    protected Integer getMark(int x, int y) {
        return x * 6 + y;
    }
}
