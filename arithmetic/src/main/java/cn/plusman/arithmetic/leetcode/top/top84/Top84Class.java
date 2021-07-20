package cn.plusman.arithmetic.leetcode.top.top84;

import java.util.Map;
import java.util.TreeMap;

/**
 * Timeout
 * @author plusman
 * @since 2021/7/18 2:38 PM
 */
@Deprecated
public class Top84Class implements Top84Solution {
    @Override
    public int largestRectangleArea(int[] heights) {
        // int[] = {start, end, maxArea}
        Map<Integer, int[]> heightArea = new TreeMap<>();
        int maxArea = Integer.MIN_VALUE;
        
        for (int i = 0; i < heights.length; i++) {
            Integer height = heights[i];
    
            int finalI = i;
            heightArea.computeIfAbsent(height, (k) -> findPrev(heightArea, height, finalI));
    
            for (Integer key : heightArea.keySet()) {
                int[] areaArr = heightArea.get(key);
                if (key.compareTo(height) <= 0) {
                    if (i - areaArr[1] <= 1) {
                        areaArr[1] = i;
                        areaArr[2] = (areaArr[1] - areaArr[0] + 1) * key.intValue();
                    } else if (key.equals(height)) {
                        areaArr = findPrev(heightArea, height, finalI);
                        heightArea.put(height, areaArr);
                    }
                    
                    if (areaArr[2] > maxArea) {
                        maxArea = areaArr[2];
                    }
                } else {
                    break;
                }
            }
        }
        
        return maxArea;
    }
    
    protected int[] findPrev(Map<Integer, int[]> heightArea, Integer height, int i) {
        for (Integer key : heightArea.keySet()){
            if (key > height) {
                int[] area = heightArea.get(key);
                if (i - area[1] <= 1) {
                    return new int[]{
                        area[0],
                        i,
                        (i - area[0] + 1) * height.intValue()
                    };
                }
            }
        }
        return new int[]{i, i, height.intValue()};
    }
}
