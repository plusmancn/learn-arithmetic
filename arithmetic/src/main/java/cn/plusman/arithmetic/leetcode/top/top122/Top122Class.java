package cn.plusman.arithmetic.leetcode.top.top122;

/**
 * @author plusman
 * @since 2021/7/28 5:10 PM
 */
public class Top122Class implements Top122Solution {
    @Override
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int m = 0;
        
        for (int i = 0, l = prices.length; i < l; i++) {
            if (i + 1 == l || prices[i + 1] < prices[i]) {
                maxProfit += Math.max(
                    0,
                    prices[i] - prices[m]
                );
                m = i + 1;
            }
        }
        
        return maxProfit;
    }
}
