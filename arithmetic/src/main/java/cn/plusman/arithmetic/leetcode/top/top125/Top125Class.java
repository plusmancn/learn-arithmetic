package cn.plusman.arithmetic.leetcode.top.top125;

/**
 * @author plusman
 * @since 2021/7/29 11:42 PM
 */
public class Top125Class implements Top125Solution {
    @Override
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            // find start char
            for (; i < j; i++) {
                if (Character.isLetterOrDigit(s.charAt(i))) {
                    break;
                }
            }
            
            // find end char
            for (; j > i; j--) {
                if (Character.isLetterOrDigit(s.charAt(j))) {
                    break;
                }
            }
            
            if (Character.toLowerCase(s.charAt(i++)) != 
                Character.toLowerCase(s.charAt(j--))
            ) {
                return false;
            }
        }
        
        return true;
    }
}
