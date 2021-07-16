package cn.plusman.arithmetic.leetcode.top.top73;

/**
 * @author plusman
 * @since 2021/7/14 11:44 PM
 */
public class Top73Class implements Top73Soulution {
    @Override
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int markColumn = -1;
        // scan column to column
        for (int i = 0; i < n; i++) {
            boolean setThisColumn = false;
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == 0) {
                    if(markColumn == -1) {
                        markColumn = i;
                        break;
                    } else {
                        setThisColumn = true;
                        matrix[j][markColumn] = 0;
                    }
                }
            }
            
            if (setThisColumn) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        
        
        // set row by markColumn
        if (markColumn != -1) {
            for (int j = 0; j < m; j++) {
                if (matrix[j][markColumn] == 0) {
                    for(int i = 0; i < n; i++) {
                        matrix[j][i] = 0;
                    }
                }
                
                matrix[j][markColumn] = 0;
            }
        }
    }
}
