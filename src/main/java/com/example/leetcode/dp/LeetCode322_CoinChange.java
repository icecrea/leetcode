package com.example.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;


/**
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class LeetCode322_CoinChange {

    /**
     * 暴力递归法
     * # 定义：要凑出金额 n，至少要 dp(n) 个硬币
     * dp[i] = min(dp[i-coin] + 1 | coin in coins)
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            //面值比总额大，跳过
            if (amount < coin) {
                continue;
            }
            int sub = coinChange(coins, amount - coin);
            //子问题无解，无法组成该面值，跳过
            if (sub == -1) {
                continue;
            }
            min = Math.min(min, sub + 1);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * 备忘录的递归法
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        return coinChangeDP(coins, amount, dp);
    }

    public int coinChangeDP(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            //面值比总额大，跳过
            if (amount < coin) {
                continue;
            }
            int sub = coinChangeDP(coins, amount - coin, dp);
            //子问题无解，无法组成该面值，跳过
            if (sub == -1) {
                continue;
            }
            min = Math.min(min, sub + 1);
        }
        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount];
    }

    /**
     * 动态规划
     * 将自顶向下的递归转换成自底向上
     */
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    @Test
    public void test() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange3(new int[]{1, 2, 5}, 11));
    }
}
