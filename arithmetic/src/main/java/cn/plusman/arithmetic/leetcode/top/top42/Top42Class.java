package cn.plusman.arithmetic.leetcode.top.top42;

/**
 * @author plusman
 * @since 2021/7/5 4:22 PM
 */
public class Top42Class implements Top42Solution {
    @Override
    public int trap(int[] height) {
        int sum = 0;
        int start = 0;
        int end = height.length - 1;
        int preMinHeight = 0;
        
        while (end > start) {
            // find available edge
            while (height[start] < 1) {
                start++;
            }
            while (height[end] < 1) {
                end--;
            }
            
            // The area of higher edge contains the lower edge's.
            int minHeight = Math.min(height[start], height[end]);
            if (minHeight <= preMinHeight) {
                if (height[start] > height[end]) {
                    end--;
                } else {
                    start++;
                }
                continue;
            }
            
            for (int i = start + 1; i < end; i++) {
                 sum += Math.max(
                     minHeight - Math.max(height[i], preMinHeight), 
                     0
                 );
            }
            
            preMinHeight = minHeight;
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        
        return sum;
    }
}
