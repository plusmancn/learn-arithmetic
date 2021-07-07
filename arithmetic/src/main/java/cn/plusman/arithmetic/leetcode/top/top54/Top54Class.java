package cn.plusman.arithmetic.leetcode.top.top54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/7 3:25 PM
 */
public class Top54Class implements Top54Solution {
    @Override
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] TL = {0,0};
        int[] TR = {0, n - 1};
        int[] BR = {m - 1, n - 1};
        int[] BL = {m - 1, 0};
        
        List<Integer> list = new ArrayList<>(m * n);
        
        while (m > 1 && n > 1) {
            for (int i = TL[1]; i < TR[1]; i++) {
                list.add(matrix[TL[0]][i]);
            }
            for (int i = TR[0]; i < BR[0]; i++) {
                list.add(matrix[i][TR[1]]);  
            }
            for (int i = BR[1]; i > BL[1]; i-- ) {
                list.add(matrix[BR[0]][i]);
            }
            for (int i = BL[0]; i > TL[0]; i--) {
                list.add(matrix[i][BL[1]]);
            }
            
            TL[0]++;TL[1]++;
            TR[0]++;TR[1]--;
            BR[0]--;BR[1]--;
            BL[0]--;BL[1]++;
            
            m -= 2;
            n -= 2;
        }
        
        if (m == 1) {
            for (int i = TL[1]; i <= TR[1]; i++) {
                list.add(matrix[TL[0]][i]);
            }
            return list;
        }
    
        if (n == 1) {
            for (int i = TR[0]; i <= BR[0]; i++) {
                list.add(matrix[i][TR[1]]);
            }
            return list;
        }
        
        return list;
    }
}
