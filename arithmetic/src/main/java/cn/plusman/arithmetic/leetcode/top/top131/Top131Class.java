package cn.plusman.arithmetic.leetcode.top.top131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author plusman
 * @since 2021/10/21 10:12 PM
 */
public class Top131Class implements Top131Solution {
    private boolean dp[][];
    private List<List<String>> list = new ArrayList<>();
    
    @Override
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
        
        dfs(new ArrayList<>(), s, 0, n);
        
        return list;
    }
    
    /**
     * 深度遍历回溯
     * @param 
     * @param s
     * @param i
     */
    public void dfs(List<String> ans, String s, int i, int n) {
        if (i >= n) {
            list.add(new ArrayList<>(ans));
            return;
        }
        
        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(ans, s, j + 1, n);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
