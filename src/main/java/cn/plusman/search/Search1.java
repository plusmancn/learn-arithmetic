package cn.plusman.search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Search1 {

    /**
     * 查找第一个值等于给定值的元素
     */
    public static int searchAhead(int[] a, int key) {
        int low = 0;
        int high = a.length -1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) >>> 1;

            if(a[mid] == key) {
                if(mid != 0 && a[mid -1] == key) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if(a[mid] > key) {
                high = mid - 1;
            } else if(a[mid] < key) {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public static int searchBackwards(int[] a, int key) {
        int low = 0;
        int high = a.length -1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) >>> 1;

            if(a[mid] == key) {
                if(mid != a.length - 1 && a[mid + 1] == key) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else if(a[mid] > key) {
                high = mid - 1;
            } else if(a[mid] < key) {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public static int searchFirstBigger(int[] a, int key) {
        int low = 0;
        int high = a.length -1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) >>> 1;

            if(a[mid] < key) {
                low = mid + 1;
            } else {
                if(mid != 0 && a[mid -1] >= key) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }

        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    public static int searchFirstLess(int[] a, int key) {
        int low = 0;
        int high = a.length -1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) >>> 1;

            if(a[mid] > key) {
                high = mid - 1;
            } else {
                if(mid != a.length -1 && a[mid+1] <= key) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
        }

        return -1;
    }


    /**
     * 在 O(logN) 时间内，从循环有序数组里查找元素
     * 二分之后，总有一半是有序数组
     */
    public static int searchInLoopSortedArray(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]) {
                if(nums[mid] > target  && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(nums[low] > nums[mid]) {
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return  -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 8, 8, 8, 8, 10};
        System.out.println("searchAhead: " + searchAhead(a, 8));
        System.out.println("searchBackwards: " + searchBackwards(a, 8));
        System.out.println("binarySearch：" + Arrays.binarySearch(a, 8));
        System.out.println("searchFirstBigger：" + searchFirstBigger(a, 9));
        System.out.println("searchFirstLess: " + searchFirstLess(a, 8));

        // 循环有序数组：https://leetcode.com/problems/search-in-rotated-sorted-array/
        int[] b1 = {4,5,6,7,0,1,2};
        int[] b2 = {1};
        int[] b3 = {1, 3};
        System.out.println("searchInLoopSortedArray: target 0 should return 4, actually = " + searchInLoopSortedArray(b1, 0));
        System.out.println("searchInLoopSortedArray: target 3 should return -1, actually = " + searchInLoopSortedArray(b1, 3));
        System.out.println("searchInLoopSortedArray: target 0 should return -1, actually = " + searchInLoopSortedArray(b2, 0));
        System.out.println("searchInLoopSortedArray: target 0 should return -1, actually = " + searchInLoopSortedArray(b3, 0));

        // LeetCode 33 加了一个条件：You may assume no duplicate exists in the array.
        // int[] b2 = {1, 7, 0, 1, 1, 1, 1};
        // System.out.println("searchInLoopSortedArray: target 0 should return 2, actually = " + searchInLoopSortedArray(b2, 0));
    }
}
