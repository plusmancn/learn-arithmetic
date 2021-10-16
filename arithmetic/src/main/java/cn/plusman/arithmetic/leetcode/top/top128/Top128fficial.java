package cn.plusman.arithmetic.leetcode.top.top128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author plusman
 * @since 2021/10/16 11:50 PM
 */
public class Top128fficial implements Top128Solution{
    @Override
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
    
        int max = 1;
    
        for (int num : numsSet) {
            if (numsSet.contains(num - 1)) {
                continue;
            }
            
            int curLength = 1;
            while (numsSet.contains(++num)) {
                curLength++;
            }
            
            max = Math.max(curLength, max);
        }
        
        
        return max;
    }
}
