package cn.plusman.arithmetic.leetcode.top.top84;

import java.util.Stack;

/**
 * @author plusman
 * @since 2021/7/18 5:43 PM
 */
public class Top84StackClass implements Top84Solution {
    @Override
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        
        int ans = 0;
        
        for (int i = 0; i <= n; i++) {
            int height = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int index = stack.pop();
                ans = Math.max(
                    ans,
                    (i - 1 - left[index]) * heights[index]
                );
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        return ans;
    }
}
