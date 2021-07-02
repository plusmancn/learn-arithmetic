package cn.plusman.arithmetic.leetcode.top.top15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author plusman
 * @since 2021/7/1 11:55 PM
 */
public class Top15Class implements Top15Solution {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<>();
        
        // The nums at least have three elements
        if (nums.length < 3) {
            return rtn;
        }
        
        // Ascending order 
        quickSort(nums, 0, nums.length - 1);
        
        // split nums into (-∞, -1] and [0, +∞) parts
        int positionPositive = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                positionPositive = i;
                break;
            }
        }
    
        // if no positive numbers, just return 
        if (positionPositive == -1) {
            return rtn;
        }
        
        // find three zero combination
        for (int i = 0; ;i++) {
            if (i == 3) {
                rtn.add(Arrays.asList(0,0,0));
                break;
            }
            
            if (positionPositive + i < nums.length) {
                if (nums[positionPositive + i] == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        // peek two nums from positive part, and peek one from the other.
        for (int i = positionPositive; i < nums.length - 1; i++) {
            // pruning
            if (nums[i] + nums[0] > 0) {
                break;
            }
            
            if ( i -1 >= positionPositive && nums[i-1] == nums[i]) {
                continue;
            }
            
            for (int j = i + 1; j < nums.length; j++) {
                if (j - 1 >= i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                
                for (int k = 0; k < positionPositive; k++) {
                    if (nums[k] + sum > 0) {
                        break;
                    }
                    
                    if (nums[k] + sum == 0 && 
                    (k - 1 < 0 || nums[k-1] != nums[k])) {
                        rtn.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        break;
                    }
                }
            }
        }
    
        // peek two nums from negative part, and peek one from the other.
        for (int i = 0; i < positionPositive - 1; i++) {
            if (nums[i] + nums[nums.length - 1] < 0) {
                continue;
            }
            
            if (i - 1 >= 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            for (int j = i + 1; j < positionPositive; j++) {
                if (j - 1 >= i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                
                int sum = nums[i] + nums[j];
            
                for (int k = nums.length - 1; k >= positionPositive; k--) {
                    if (nums[k] + sum < 0) {
                        break;
                    }
                    
                    if (nums[k] + sum == 0 && (k + 1 == nums.length || nums[k+1] != nums[k])) {
                        rtn.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        break;
                    }
                }
            }
        }
        
        return rtn;
    }
    
    /**
     * QuickSort in original place 
     * O(s) = 1;
     * O(t) = NlogN
     * @param nums
     * @param s
     * @param e
     */
    private void quickSort(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }
        
        int p = partition(nums, s, e);
        quickSort(nums, s, p -1);
        quickSort(nums, p + 1, e);
    }
    
    private int partition(int[] nums, int s, int e) {
        int pivot = nums[e];
        int i = s;
        for (int j = s; j < e; j++) {
            if (nums[j] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
     
        nums[e] = nums[i];
        nums[i] = pivot;
        
        return i;
    }
}
