package cn.plusman.arithmetic.leetcode.top.top134;

import java.util.Arrays;

/**
 * @author plusman
 * @since 2021/10/22 9:32 PM
 */
public class Top134MyClass implements Top134Solution {
    @Override
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        for (int i = 0; i < n;) {
            int remain = gas[i];
            
            for (int j = i, step = 0; step <= n; step++) {
                // 成功抵达目的地
                if (step == n) {
                    return i;
                }
                // 先到达
                remain -= cost[j++ % n];
                
                if (remain < 0) {
                    i = j;
                    break;
                }
                // 才能加油    
                remain += gas[j % n];
            }
        }
        
        return -1;
    }
}
