package cn.plusman.arithmetic.leetcode.top.top7;

/**
 * @author plusman
 * @since 2021/6/15 12:28 AM
 */
public class Top7Class implements Top7Solution {
    @Override
    public int reverse(int x) {
        int res = 0;
        int y = x;
        
        while (y != 0) {
            int digit = y % 10;
            y /= 10;
            
            if (Integer.MAX_VALUE / 10 < res || Integer.MIN_VALUE / 10 > res) {
                return 0;
            } 
            // 在本题场景下可以忽略，因为最高位最大是 2，明显是 [-8,7] 的集合内 
            else if (Integer.MAX_VALUE / 10 == res) {
                if (Integer.MAX_VALUE % 10 < digit) {
                    return 0;
                }
            } else if (Integer.MIN_VALUE / 10 == res) {
                if (Integer.MIN_VALUE % 10 > digit) {
                    return 0;
                }
            }
            
            // 此处会发生溢处
            res = res * 10 + digit;
        }
        
        return res;
    }
}
