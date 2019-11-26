package com.example.leetcode.dp;

import java.util.Arrays;

/**
 * 最长上升子序列 LIS问题
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LeetCode300_LongestIncreasingSubsequence {

    /**
     * dp[i]： 以i结尾的最长递增子序列长度  O(N^2)
     * 问题在于如何根据dp[0]...dp[i-1]，来推导dp[i]
     * 10,9,2,5,3,7,101,18
     * 1 ,1,1,2,2,3,4,  4
     */
    public int lengthOfLIS(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}
