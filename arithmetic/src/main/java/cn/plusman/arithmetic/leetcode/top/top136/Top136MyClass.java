package cn.plusman.arithmetic.leetcode.top.top136;

/**
 * @author plusman
 * @since 2021/10/25 12:38 PM
 */
public class Top136MyClass implements Top136Solution {
    @Override
    public int singleNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            boolean isUnique = true;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    // 正好在数据范围之外
                    nums[j] = Integer.MAX_VALUE;
                    isUnique = false;
                    break;
                }
            }
            if (!isUnique) {
                nums[i] = Integer.MAX_VALUE;
            } else {
                return nums[i];  
            }
        }
        
        // 基于数据内容，该值永远不回被返回
        return 0;
    }
}
