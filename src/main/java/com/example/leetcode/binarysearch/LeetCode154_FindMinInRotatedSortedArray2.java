package com.example.leetcode.binarysearch;

import org.junit.Test;

/**
 * @description: 寻找旋转排序数组中的最小值2
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * @auther: icecrea
 * @date: 2019/12/19
 */
public class LeetCode154_FindMinInRotatedSortedArray2 {
    /**
     * 有了重复元素，主要问题在于相等情况取哪个区间 如 1，3，3 、 3，3，1，3 两种情况
     * 当nums[mid] == nums[right]时，可以把right舍弃，因为两者相等，所以必然不会影响结果
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) >>> 1;
            //中大于右， 最小值必然在右侧
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else {
                right--;
            }
        }
        return nums[left];
    }

    @Test
    public void test() {
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findMin(new int[]{2, 3, 4, 5, 1}));
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{1, 3, 3}));
        System.out.println(findMin(new int[]{3, 3, 1}));
        System.out.println(findMin(new int[]{3, 3, 1, 3}));
    }
}
