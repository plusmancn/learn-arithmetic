package cn.plusman.arithmetic.leetcode.top.top128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author plusman
 * @since 2021/10/16 11:03 PM
 */
public class Top128Class implements Top128Solution {
    @Override
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> lookMap = new HashMap<>(30);
    
        for (int num : nums) {
            // search in left
            int curValue = lookMap.getOrDefault(num - 1, 0);
            lookMap.put(num, ++curValue);
            
            // accumulate to right
            int curKey = num + 1;
            int count = 0;
            while (lookMap.get(curKey) != null ) {
                // 中间数据可以被忽略
                curKey++;
                count++;
            }
            
            if (count > 0) {
                curValue = curValue + count;
                lookMap.put(curKey - 1, curValue);
            }
            
            if (curValue > max) {
                max = curValue;
            }
        }
        
        return max;
    }
}
