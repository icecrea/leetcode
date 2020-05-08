package com.example.leetcode.dp;

/**
 * @description: 01背包问题简单版-容纳的最大重量
 * 对于一组不同重量、不可分割的物品,我们需要选择一些装入背包,在满足背包最大重量限制的前提下,背包中物品总重量的最大值是多少呢？
 * @auther: icecrea
 * @date: 2020/5/8
 */
public class Knapsack_MaxWeight {

    public int max = 0;

    /**
     * 回溯法：
     * 假设背包可承受重量100,物品个数10：maxWeight(0, 0, a, 10, 100)
     *
     * @param i         考察到哪个物品
     * @param curWeight 当前已经放进背包的物品总重量
     * @param items     每个物品的重量
     * @param n         放入背包个数
     * @param w         背包最大重量
     */
    public void maxWeight(int i, int curWeight, int[] items, int n, int w) {
        if (curWeight == w || i == n) { // curWeight==w表示装满了;i==n表示已经考察完所有的物品
            if (curWeight > max) {
                max = curWeight;
            }
            return;
        }
        //不装第i个物品
        maxWeight(i + 1, curWeight, items, n, w);
        //装第i个物品
        if (curWeight + items[i] <= w) {// 已经超过可以背包承受的重量的时候,就不要再装了
            maxWeight(i + 1, curWeight + items[i], items, n, w);
        }
    }

    /**
     * dp
     *
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public int maxWeight2(int[] weight, int n, int w) {
        int[][] dp = new int[n][w + 1];
        dp[0][0] = 1;
        //第一行特殊处理
        if (weight[0] <= w) {
            dp[0][weight[0]] = 1;
        }
        for (int i = 0; i < n; i++) {
            //不放入第i个物品
            for (int j = 0; j < w + 1; j++) {
                if (dp[i - 1][j] == 1) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            //放入第i个物品
            for (int j = 0; j <= w - weight[i]; j++) {
                if (dp[i - 1][j] == 1) {
                    dp[i][j + weight[i]] = 1;
                }
            }
        }

        for (int j = w; j >= 0; j--) {
            if (dp[n - 1][j] == 1) {
                return j;
            }
        }
        return 0;
    }


}
