package com.example.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 一个集合切割能否分成和相同的两部分
 * @auther: icecrea
 * @date: 2020/5/7
 */
public class Knapsack_SplitTwoPartSame {


    boolean isSame2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum / 2;
        int[][] dp = new int[nums.length][sum + 1];
        if (nums[0] <= sum) {
            dp[0][nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i - 1][j] == 1) {
                    dp[i][j] = 1;
                }
            }
            for (int j = 0; j + nums[i] <= sum; j++) {
                if (dp[i - 1][j] == 1) {
                    dp[i][j + nums[i]] = 1;
                }
            }
            if (dp[i][sum] == 1) {
                return true;
            }
        }
        return false;
    }

    boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 2, 3}));
        System.out.println(canPartition(new int[]{1, 1, 3}));
        System.out.println(canPartition(new int[]{1, 1, 4}));
        System.out.println(canPartition(new int[]{1, 1, 1, 3}));
        System.out.println(canPartition(new int[]{1, 2, 8, 9}));
        System.out.println("------------------------");
        System.out.println(isSame2(new int[]{1, 2, 3}));
        System.out.println(isSame2(new int[]{1, 1, 3}));
        System.out.println(isSame2(new int[]{1, 1, 4}));
        System.out.println(isSame2(new int[]{1, 1, 1, 3}));
        System.out.println(isSame2(new int[]{1, 2, 8, 9}));
    }
}
