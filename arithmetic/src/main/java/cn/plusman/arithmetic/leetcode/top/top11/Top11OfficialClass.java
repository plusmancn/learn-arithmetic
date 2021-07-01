package cn.plusman.arithmetic.leetcode.top.top11;

/**
 * Official
 * @author plusman
 * @since 2021/6/30 8:12 PM
 */
public class Top11OfficialClass implements Top11Solution{
    @Override
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int sMax = Math.min(height[start], height[end]) * (end - start);
        
        while (start != end) {
            if (height[start] < height[end]) {
                start++;
            } else {
                end --;
            }
            int tmp =  Math.min(height[start], height[end]) * (end - start);
            if (tmp > sMax) {
                sMax = tmp;
            }
        }
        
        return sMax;
    }
}
