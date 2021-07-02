package cn.plusman.arithmetic.leetcode.top.top22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/2 9:38 PM
 */
public class Top22Class implements Top22Solution {
    @Override
    public List<String> generateParenthesis(int n) {
        int[] insertArr = new int[n];
        List<String>  list = new ArrayList<>();
        
        backUpon(insertArr, list, 0, 0);
        
        return list;
    }
    
    protected void backUpon(int[] insertArr, List<String> list, int now, int consume) {
        // renderParentheses
        if (now == insertArr.length - 1) {
            insertArr[insertArr.length - 1] = insertArr.length - consume;
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < insertArr.length; i++) {
                sb.append('(');
                for (int j = 0; j < insertArr[i]; j++) {
                    sb.append(')');
                }
            }
            list.add(sb.toString());
            return;
        }
        
        for (int i = 0; i <= now + 1 - consume; i++) {
            insertArr[now] = i;
            backUpon(insertArr, list, now + 1, consume + i);
        }
    }
}
