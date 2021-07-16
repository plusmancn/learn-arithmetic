package cn.plusman.arithmetic.leetcode.top.top78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/16 5:59 PM
 */
public class Top78Class implements Top78Solution {
    @Override
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList());
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int curSize = list.size();
            for (int j = 0; j < curSize; j++) {
                List<Integer> temp =new ArrayList<>(list.get(j));
                temp.add(num);
                list.add(temp);
            }
        }
        
        return list;
    }
}
