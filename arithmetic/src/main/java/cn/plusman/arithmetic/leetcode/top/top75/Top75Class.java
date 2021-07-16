package cn.plusman.arithmetic.leetcode.top.top75;

/**
 * @author plusman
 * @since 2021/7/15 5:37 PM
 */
public class Top75Class implements Top75Solution {
    @Override
    public void sortColors(int[] nums) {
        int i = 0, j = i, k = i;
    
        for (int num : nums) {
            if (num == 2) {
                k++;
            }
            
            if (num == 1) {
                nums[j++] = 1;
                if (++k> j) {
                    nums[k-1] = 2;
                }
            }
            
            if(num == 0) {
                nums[i++] = 0;
                if (++j > i) {
                    nums[j-1] = 1;
                }
                if (++k > j) {
                    nums[k-1] = 2;
                }
            }
        }
    }
}
