package com.example.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 */
public class LeetCode673_NumberOfLongestIncreasingSubsequence {

    /**
     * dpLen[i] : 以第i个数结尾的最长序列的个数
     *
     * 1 3 7 4 2 8
     * 1 2 3 3 2 4
     * 1 1 1 1 1 2
     *
     * 1 3 7
     * 1 2 3
     * 1 1 1
     */
    public int findNumberOfLIS(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] dp = new int[a.length];
        int[] dpLen = new int[a.length];
        int max = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(dpLen, 1);
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        dpLen[i] = dpLen[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        dpLen[i] += dpLen[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        for (int i = 0; i < dpLen.length; i++)
            System.out.print(dpLen[i]);
        System.out.println();
        int maxLen = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                maxLen += dpLen[i];
            }
        }
        return maxLen;
    }

    @Test
    public void test() {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 7, 4, 2, 8}));
        // 1 3 5 4 7
        // 1 2 3 3 4
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5}));
    }
}
