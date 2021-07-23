package cn.plusman.arithmetic.leetcode.top.top118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/23 5:38 PM
 */
public class Top118Class implements Top118Solution {
    
    @Override
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rtn = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(
                        rtn.get(i - 1).get(j) +
                        rtn.get(i - 1).get(j-1)
                    );
                }
            }
            rtn.add(line);
        }
        
        return rtn;
    }
}
