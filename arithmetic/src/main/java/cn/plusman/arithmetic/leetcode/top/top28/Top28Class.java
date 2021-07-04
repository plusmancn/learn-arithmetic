package cn.plusman.arithmetic.leetcode.top.top28;

/**
 * @author plusman
 * @since 2021/7/3 2:18 PM
 */
public class Top28Class implements Top28Solution {
    @Override
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for(int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}
