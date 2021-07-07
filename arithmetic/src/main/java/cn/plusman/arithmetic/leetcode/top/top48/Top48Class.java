package cn.plusman.arithmetic.leetcode.top.top48;

/**
 * @author plusman
 * @since 2021/7/6 3:55 PM
 */
public class Top48Class implements Top48Solution {
    @Override
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int n = matrix.length;
        while (n > 1) {
            int offset = (size - n) / 2;
            int[] topLeft = new int[]{0 + offset, 0 + offset};
            int[] topRight = new int[]{0 + offset, size - 1 - offset};
            int[] bottomRight = new int[]{size - 1 - offset, size - 1 -offset};
            int[] bottomLeft = new int[]{size - 1 - offset, 0 + offset};
            
            for (int i = 0; i < n - 1; i++) {
                int pre = matrix[topLeft[0]][topLeft[1] + i];
                for (int j = 0; j < 4; j++) {
                    if (j == 0) {
                        int tmp = matrix[topRight[0] + i][topRight[1]];
                        matrix[topRight[0] + i][topRight[1]] = pre;
                        pre = tmp;
                    }
                    if (j == 1) {
                        int tmp = matrix[bottomRight[0]][bottomRight[1] - i];
                        matrix[bottomRight[0]][bottomRight[1] - i] = pre;
                        pre = tmp;
                    }
                    if (j == 2) {
                        int tmp = matrix[bottomLeft[0] - i][bottomLeft[1]];
                        matrix[bottomLeft[0] - i][bottomLeft[1]] = pre;
                        pre = tmp;
                    }
                    
                    if (j == 3) {
                        matrix[topLeft[0]][topLeft[1] + i] = pre;
                    }
                }
            }
            
            n -= 2;
        }
    }
}
