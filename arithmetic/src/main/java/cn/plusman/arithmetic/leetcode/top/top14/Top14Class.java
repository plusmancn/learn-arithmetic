package cn.plusman.arithmetic.leetcode.top.top14;

/**
 * @author plusman
 * @since 2021/7/1 11:19 AM
 */
public class Top14Class implements Top14Solution {
    @Override
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        
        for (int i = 0; i < minLength; i++) {
            boolean stop = false;
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (ch != strs[j].charAt(i)) {
                    stop = true;
                    break;
                }
            }
            if (!stop) {
                sb.append(ch);
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
}
