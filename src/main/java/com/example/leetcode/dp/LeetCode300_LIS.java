package com.example.leetcode.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 最长上升子序列
 * LIS问题 LongestIncreasingSubsequence
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LeetCode300_LIS {

    /**
     * dp[i]： 以i结尾的最长递增子序列长度  O(N^2)
     * 问题在于如何根据已知的dp[0]...dp[i-1]，来推导dp[i]
     * 10,9,2,5,3,7,101,18
     * 1 ,1,1,2,2,3,4,  4
     */
    public int lengthOfLIS(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        //dp[i] 以i结尾的最长递增子序列长度
        int dp[] = new int[a.length];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int j = 1; j < a.length; j++) {
            for (int i = 0; i < j; i++) {
                if (a[j] > a[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            max = Math.max(max, dp[j]);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
