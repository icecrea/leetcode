package com.example.leetcode.binarysearch;

import org.junit.Test;

/**
 * @description: 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * @auther: icecrea
 * @date: 2019/12/19
 */
public class LeetCode153_FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) >>> 1;
            //中大于右， 最小值必然在右侧
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    @Test
    public void test() {
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findMin(new int[]{2, 3, 4, 5, 1}));
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
