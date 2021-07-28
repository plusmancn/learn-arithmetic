package cn.plusman.arithmetic.leetcode.top.top121;

/**
 * @author plusman
 * @since 2021/7/28 1:02 PM
 */
public class Top121Official implements Top121Solution {
    @Override
    public int maxProfit(int[] prices) {
        int m = 0, n = 0;
        int maxProfit =0;
        
        for (int i = 1, l = prices.length; i < l; i++) {
            if (prices[m] > prices[i]) {
                m = i;
            } else if (prices[m] < prices[i]) {
                n = i;
            }
            
            if (m < n) {
                maxProfit = Math.max(
                    maxProfit,
                    prices[n] - prices[m]
                );
            }
        }
        
        return maxProfit;
    }
}
