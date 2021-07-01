package cn.plusman.arithmetic.leetcode.top.top11;

/**
 * myself
 * @author plusman
 * @since 2021/6/30 6:42 PM
 */
public class Top11Class implements Top11Solution {
    @Override
    public int maxArea(int[] height) {
        int hStart = 0;
        int hEnd = height.length - 1;
        
        int sMax = Math.min(height[hStart], height[hEnd]) * (hEnd - hStart);
        
        // StartPoint move to right step by step.
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > hStart) {
                int hEndMin = (int)(Math.ceil((double) sMax / height[i])) + i;
                for (int j = height.length - 1; j >= hEndMin; j--) {
                    int tmp = Math.min(height[i], height[j]) * (j-i);
                    if (tmp > sMax) {
                        sMax = tmp;
                    }
                }
            }
        }
        
        return sMax;
    }
}
