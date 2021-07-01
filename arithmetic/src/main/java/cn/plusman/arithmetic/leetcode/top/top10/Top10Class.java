package cn.plusman.arithmetic.leetcode.top.top10;

import cn.plusman.arithmetic.leetcode.top.InspectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Regexp
 * @author plusman
 * @since 2021/6/29 11:13 PM
 */
public class Top10Class implements Top10Solution {
    @Override
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        
        // ==========> PreHandle
        // PatternList
        List<String> patternList = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if (i + 1 == p.length() || p.charAt(i+1) != '*') {
                patternList.add(p.substring(i, i+1));
            } else {
                patternList.add(p.substring(i, ++i + 1));
            }
        }
        
        // ==========> FillTable
        boolean[][] table = new boolean[patternList.size()][s.length() + 1];
        
        for (int i = 0; i < patternList.size(); i++) {
            String pattern = patternList.get(i);
            
            for (int j = 0; j <= s.length(); j++) {
                // First line should be handled separately
                if (i == 0) {
                    if (pattern.contains("*")) {
                        if (j == 0) {
                            table[i][j] = true;
                        } else {
                            table[i][j] = isMatchSubPattern(s.charAt(j-1), pattern) && table[i][j-1];
                        }
                    } else {
                        if (j == 0) {
                            table[i][j] = false;
                        } else {
                            table[i][j] = isMatchSubPattern(s.charAt(j-1), pattern);
                            break;
                        }
                    }
                }
                
                // From second line
                if (i >= 1) {
                    if (pattern.contains("*")) {
                        if (j==0) {
                            table[i][j] = table[i-1][j];
                        } else {
                            table[i][j] = table[i-1][j] || (
                                isMatchSubPattern(s.charAt(j-1), pattern) &&
                                    table[i][j-1]
                            );
                        }
                        
                    } else {
                        if (j == 0) {
                            table[i][j] = false;
                        } else {
                            table[i][j] = table[i-1][j-1] && (
                                isMatchSubPattern(s.charAt(j-1), pattern)
                            );
                        }
                    }
                }
            }
        }
        
        InspectUtil.showArray(table);
        
        return table[patternList.size() - 1][s.length()];
    }
    
    private boolean isMatchSubPattern(Character ch, String pattern) {
        if (pattern.charAt(0) == '.') {
            return true;
        }
        
        return ch == pattern.charAt(0);
    }
}
