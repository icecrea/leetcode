package com.example.leetcode.dp;

import com.alibaba.fastjson.JSON;
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
        //dp[i][j] 对前i个物品，重量为j时能装下的最大价值
        //base case i=0或j=0 dp[i][j]=0 即重量为0，个数为0，最大价值为0
        int[][] dp = new int[maxSize + 1][maxWeight + 1];
        for (int i = 1; i <= maxSize; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (j >= weight[i - 1]) { //能装下情况 选择装或不装的最优解
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(JSON.toJSONString(dp));
        return dp[maxSize][maxWeight];
    }

    /**
     * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
     */
    public int knapsack2(int[] weight, int[] value, int n, int w) {
        //dp[i][j] 前i个物品，当背包重量为j时背包的最大价值
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < w + 1; ++j) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        if (weight[0] <= w) {
            dp[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (dp[i - 1][j] >= 0) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                if (dp[i - 1][j] >= 0) {
                    dp[i][j + weight[i]] = Math.max(dp[i][j + weight[i]], dp[i - 1][j] + value[i]);
                }
            }
        }
        // 找出最大值
        int max = -1;
        for (int j = 0; j <= w; ++j) {
            max = Math.max(dp[n - 1][j], max);
        }
        System.out.println(JSON.toJSONString(dp));
        return max;
    }


    @Test
    public void test() {
        //物品数3 容量大小4
        System.out.println(knapsack(3, 4, new int[]{2, 1, 3}, new int[]{4, 2, 3}));
        System.out.println(knapsack(5, 9, new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6}));
        System.out.println(knapsack2(new int[]{2, 1, 3}, new int[]{4, 2, 3}, 3, 4));
        System.out.println(knapsack2(new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6}, 5, 9));
        /**
         * 0,0,0,0,0,0,0,0,0,0
         * 0,0,3,3,3,3,3,3,3,3
         * 0,0,4,4,7,7,7,7,7,7
         * 0,0,4,4,8,8,12,12,15,15
         * 0,0,4,4,8,8,12,12,15,15
         * 0,0,4,6,8,10,12,14,15,18
         */
    }
}
