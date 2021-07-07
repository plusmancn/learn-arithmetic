package cn.plusman.arithmetic.leetcode.top.top50;

/**
 * @author plusman
 * @since 2021/7/6 6:19 PM
 */
public class Top50Class implements Top50Solution {
    @Override
    public double myPow(double x, int n) {
        double result = 1.0;
        // be careful about int overflow
        long N = n;
        long pow = Math.abs(N);

        while (pow > 0) {
            if (pow % 2 == 1.0) {
                result *= x;
            }
            x *=x;
            pow = pow / 2;
        }

        return n < 0 ? 1/result : result;
    }
}
