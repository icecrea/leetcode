package com.example.leetcode.sort;

import java.util.Arrays;

/**
 * @description: 摆动排序2
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * @author: icecrea
 * @create: 2019-04-10 10:05
 **/
public class LeetCode324_WiggleSort2 {


    /**
     * 先对数组排序，分为大数部分和小数部分，再穿插排序。 注意顺序，例如[1，2，4，4，4，6]这个数组，
     * 通过降序穿插得到[4,6,2,4,1,4]。 如果顺序排列，则会得到[1,4,2,4,4,6]不满足要求。
     * 这里是因为我们想尽量将小数部分的最大数放在边上，这样只用靠近一个大数部分的最大数。
     * <p>
     * 输入
     * [1,1,2,1,2,2,1] 1111222 1 111 222 1212121
     * 输出
     * [1,2,1,2,1,2,2]
     * 预期结果
     * [1,2,1,2,1,2,1]
     * <p>
     * 输入
     * [5,3,1,2,6,7,8,5,5] 1 2355 5678 58372615
     * 输出
     * [5,8,3,7,2,6,1,5,5]
     * 预期结果
     * [5,8,5,7,3,6,2,5,1]
     * <p>
     * 111456 161514
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        int[] a = new int[nums.length];

        int p = (nums.length - 1) / 2;
        int q = nums.length - 1;

        int n = 0;
        int i = 0;
        while (n < nums.length / 2) {
            a[i] = nums[p--];
            a[i + 1] = nums[q--];
            i = i + 2;

            n++;
        }

        if ((nums.length & 1) != 0) {
            a[nums.length - 1] = nums[0];
        }

        System.arraycopy(a, 0, nums, 0, nums.length);
    }


}
