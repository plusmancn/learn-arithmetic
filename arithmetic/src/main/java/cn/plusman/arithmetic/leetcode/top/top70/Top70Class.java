package cn.plusman.arithmetic.leetcode.top.top70;

/**
 * @author plusman
 * @since 2021/7/14 3:47 PM
 */
public class Top70Class implements Top70Solution {
    private final static int[] cache = new int[45];
    
    @Override
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        
        if (cache[n - 1] == 0) {
            cache[n - 1] = climbStairs(n - 1) + climbStairs(n - 2);
        }
        
        return cache[n - 1];
    }
}
