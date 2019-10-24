package com.example.leetcode.array;

/**
 * @description: 循环有序数组二分查找
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: arr = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: arr = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * @author: icecrea
 * @create: 2019-10-24
 **/
public class LeetCode33_SearchInRotatedSortedArray {
    /**
     * 中间节点小于最右节点，说明右半部分有序
     * 中间节点大于最右节点，说明左半部分有序
     */
    public int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < arr[high]) { //右侧是有序的
                //判断查找的数是否在右区间中
                if (arr[mid] < target && arr[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else { //左侧是有序的
                //判断查找的数是否在右区间中
                if (arr[mid] > target && arr[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
