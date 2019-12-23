package com.example.leetcode.binarysearch;

import org.junit.Test;

/**
 * @description: 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * @auther: icecrea
 * @date: 2019/12/18
 */
public class LeetCode035_SearchInsertPosition {
    /**
     * 二分查找模板
     * 其实这道题可以转换成，大于或者等于目标值的第 1 个数的索引
     * 因为：如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 所以不用再单独判断left right
     */
    public int searchInsert(int[] nums, int target) {
        //特殊情况考虑
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            //排除中位数的逻辑 目标至少是中位数但不包括中位数
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 4));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 6));

        System.out.println(Integer.MAX_VALUE);
        System.out.println((Integer.MAX_VALUE + Integer.MAX_VALUE) >>> 1);
    }
}
