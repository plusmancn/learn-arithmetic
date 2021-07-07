package cn.plusman.arithmetic.leetcode.top.top56;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author plusman
 * @since 2021/7/7 10:57 PM
 */
public class Top56Class implements Top56Solution {
    @Override
    public int[][] merge(int[][] intervals) {
        // sort
        Arrays.sort(intervals, Comparator.comparingInt(pre -> pre[0]));
        
        // merge
        boolean[] markIndex = new boolean[intervals.length];
        int count = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            if (i == intervals.length - 1) {
                markIndex[i] = true;
                count++;
                continue;
            }
            
            if (intervals[i][1] >= intervals[i+1][0]) {
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(
                    intervals[i][1],
                    intervals[i+1][1]
                );
            } else {
                markIndex[i] = true;
                count++;
            }
        }
        
        int[][] result = new int[count][2];
        count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (markIndex[i]) {
                result[count++] = intervals[i];
            }
        }
        
        return result;
    }
}
