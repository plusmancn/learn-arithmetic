package cn.plusman.arithmetic.leetcode.top.top46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/6 1:47 PM
 */
public class Top46Class implements Top46Solution {
    @Override
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rtnList = new ArrayList<>();
        
        if (nums.length == 1) {
            List<Integer> item = new ArrayList<>();
            item.add(nums[nums.length - 1]);
            rtnList.add(item);
            return rtnList;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            int[] next = Arrays.stream(nums).filter(v -> v != nums[finalI]).toArray();
            
            List<List<Integer>> preList = permute(next);
            for (List<Integer> integers : preList) {
                integers.add(nums[finalI]);
                rtnList.add(integers);
            }
        }
        
        return rtnList;
    }
}
