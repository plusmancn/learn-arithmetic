package cn.plusman.arithmetic.leetcode.top.top36;

import java.util.HashMap;
import java.util.Map;

/**
 * @author plusman
 * @since 2021/7/4 11:40 AM
 */
public class Top36Class implements Top36Solution {
    @Override
    public boolean isValidSudoku(char[][] board) {
        // row and column check
        for (int i = 0; i < board.length; i++) {
            Map<Character, Boolean> checkMapRow = new HashMap<>(board.length);
            Map<Character, Boolean> checkMapColumn = new HashMap<>(board.length);
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    // nothing
                } else if(checkMapRow.get(board[i][j]) == null) {
                    checkMapRow.put(board[i][j], true);
                } else {
                    return false;
                }
                if (board[j][i] == '.') {
                  // nothing  
                } else if (checkMapColumn.get(board[j][i]) == null) {
                    checkMapColumn.put(board[j][i], true);
                } else {
                    return false;
                }
            }
        }
        
        // 3 x 3 sub-boxes check
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j+= 3) {
                Map<Character, Boolean> checkMapSubBox = new HashMap<>(board.length);
                // horizontal
                for (int k = 0; k < 9; k++) {
                    int subI = i + k / 3;
                    int subJ = j + k % 3;
                    
                    if (board[subI][subJ] == '.') {
                        // nothing
                    } else if (checkMapSubBox.get(board[subI][subJ]) == null) {
                        checkMapSubBox.put(board[subI][subJ], true);
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
