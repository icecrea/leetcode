package com.example.leetcode.dp;

import org.junit.Test;

/**
 * @description: 01-背包问题
 * 一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少
 * @auther: icecrea
 * @date: 2020/4/24
 */
public class Knapsack {
    /**
     * dp[i][w] 表示：对于前 i 个物品，当前背包的容量为 w 时，这种情况下可以装下的最大价值是 dp[i][w]
     */
    int knapsack(int maxSize, int maxWeight, int[] weight, int[] val) {
        // base case 已初始化
        int[][] dp = new int[maxSize + 1][maxWeight + 1];
        for (int i = 1; i <= maxSize; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                // 当前背包容量装不下
                if (w < weight[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(dp[i - 1][w - weight[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[maxSize][maxWeight];
    }

    @Test
    public void test() {
        //物品数3 容量大小4
        System.out.println(knapsack(3, 4, new int[]{2, 1, 3}, new int[]{4, 2, 3}));
    }
}
