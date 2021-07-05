package cn.plusman.arithmetic.leetcode.top.top42;

/**
 * @author plusman
 * @since 2021/7/5 5:21 PM
 */
public class Top42ColumnClass implements Top42Solution {
    @Override
    public int trap(int[] height) {
        if (height.length < 1) {
            return 0;
        }
        
        int sum = 0;
        int start = 0;
        int end = height.length - 1;
        int preMinHeight = Math.min(height[start], height[end]);
        
        while (end > start) {
            int change;
            if (height[start] > height[end]) {
                change = --end;
            } else {
                change = ++start;
            }
            
            sum += Math.max(preMinHeight - height[change], 0);
            preMinHeight = Math.max(
                Math.min(height[start], height[end]),
                preMinHeight
            );
        }
        
        return sum;
    }
    
}
