package cn.plusman.arithmetic.leetcode.top.top121;

/**
 * @author plusman
 * @since 2021/7/28 11:06 AM
 */
public class Top121Class implements Top121Solution {
    @Override
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxValuePos = -1;
        int maxProfit = 0;
        for (int i = 0, n = prices.length; i < n; i++) {
            int cur = prices[i];
            if (cur < minValue) {
                minValue = cur;
                
                if (maxValuePos > i) {
                    maxProfit = prices[maxValuePos] - minValue;
                } else {
                    for (int j = i + 1; j < n; j++) {
                        if (prices[j] < minValue) {
                            continue;
                        }
        
                        int curProfit = prices[j] - minValue;
                        if (curProfit > maxProfit) {
                            maxProfit = curProfit;
                            maxValuePos = j;
                        }
                    }
                }
            } else {
                continue;
            }
        }
        
        return maxProfit;
    }
}
