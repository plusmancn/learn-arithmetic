package cn.plusman.arithmetic.leetcode.top.top38;

/**
 * @author plusman
 * @since 2021/7/4 9:21 PM
 */
public class Top38Class implements Top38Solution {
    @Override
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String pre = countAndSay(n - 1);
        
        StringBuilder sb = new StringBuilder();
        char key = '-';
        int nums = 0;
        for (int i = 0; i < pre.length(); i++) {
            if (nums == 0) {
                key = pre.charAt(i);
                nums++;
            } else if (nums != 0 && key == pre.charAt(i)) {
                nums++;
            }
            
            if (i + 1 >= pre.length() || pre.charAt(i+1) != key) {
                sb.append(nums);
                sb.append(key);
                nums = 0;
            }
        }
        
        return sb.toString();
    }
}
