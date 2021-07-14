package cn.plusman.arithmetic.leetcode.top.top69;

/**
 * @author plusman
 * @since 2021/7/14 2:44 PM
 */
public class Top69Class implements Top69Solution {
    @Override
    public int mySqrt(int x) {
        // 65536 = 2^16
        long end = Math.min(x, 65536);
        long start = 0;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long res = mid * mid;
            
            if (res == x) {
                return (int) mid;
            } else if (res > x) {
                end = mid - 1;
            } else if (res < x) {
                start = mid + 1;
            }
        }
        
        return (int) end;
    }
}
