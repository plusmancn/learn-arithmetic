package cn.plusman.arithmetic.leetcode.top.top130;

/**
 * @author plusman
 * @since 2021/10/18 11:20 PM
 */
public class Top130Class implements Top130Solution {
    @Override
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        
        // 发出搜救员
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n -1) {
                    searchAndMark(board, i, j);
                }
            }
        }
        
        // 重新标记
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'M') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    protected void searchAndMark(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        
        // 防止重复搜索
        if (board[i][j] == 'O') {
            board[i][j] = 'M';
        } else {
            return;
        }
        
        // 四个方向搜索
        // left
        searchAndMark(board, i, j - 1);
        // top
        searchAndMark(board, i - 1, j);
        // right
        searchAndMark(board, i, j + 1);
        // bottom
        searchAndMark(board, i + 1, j);
    }
}
