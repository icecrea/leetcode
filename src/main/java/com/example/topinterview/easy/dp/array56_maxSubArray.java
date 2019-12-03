package com.example.topinterview.easy.dp;

/**
 * @description: 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *        -2 1 -2 4 3 5 6 1 5
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author: icecrea
 * @create: 2019-03-18 19:36
 **/
public class array56_maxSubArray {
    public int maxSubArray(int[] nums) {
        int maxToCur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (maxToCur >= 0) {
                maxToCur += nums[i];
            } else {
                maxToCur = nums[i];
            }
            max = Math.max(max, maxToCur);
        }
        return max;
    }
}
