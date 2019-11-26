package com.example.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机2
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class LeetCode122_BestTimeToBuyAndSellStock2 {

    /**
     * 坐标轴分析
     * 找到连续的最大差值的谷和峰，并将其累加 O(n)
     */
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            //找到连续的谷
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            //找到谷后连续的峰
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * 问题最优解：贪心算法
     * 一次遍历 在特定问题比动态规划更高效
     *
     * 在峰谷的基础上优化：
     * 可以简单地继续在斜坡上爬升并持续增加从连续交易中获得的利润，而不是在谷之后寻找每个峰值
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }


    /**
     * 暴力法 递归求解
     * 可以对比上一题暴力法
     *
     * @see LeetCode121_BestTimeToBuyAndSellStock#maxProfit2(int[])
     */
    public int maxProfit3(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int start) {
        if (start >= prices.length) {
            return 0;
        }
        int maxprofit = 0;
        for (int buy = start; buy < prices.length; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                //递归的穷举所有可能 最大盈利= max(最大盈利， 当前售出盈利+下一轮的盈利)
                maxprofit = Math.max(maxprofit, calculate(prices, sell + 1) + prices[sell] - prices[buy]);
            }
        }
        return maxprofit;
    }


    /**
     * 暴力优化 减少一层循环 以及通过dptable优化
     * 可以参考
     *
     * @see LeetCode121_BestTimeToBuyAndSellStock#maxProfit3(int[])
     */
    public int maxProfit4(int prices[]) {
        //构架dptable优化记忆
        int[] dpTable = new int[prices.length];
        Arrays.fill(dpTable, -1);
        return dp(prices, 0, dpTable);
    }

    public int dp(int prices[], int start, int[] dpTable) {
        if (start >= prices.length) {
            return 0;
        }
        if (dpTable[start] != -1) {
            return dpTable[start];
        }
        int maxprofit = 0;
        int curMin = prices[start];
        for (int sell = start + 1; sell < prices.length; sell++) {
            curMin = Math.min(curMin, prices[sell]);
            maxprofit = Math.max(maxprofit, dp(prices, sell + 1, dpTable) + prices[sell] - curMin);
        }
        dpTable[start] = maxprofit;
        return maxprofit;
    }


    @Test
    public void test() {
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit4(new int[]{7, 1, 5, 3, 6, 4}));

        System.out.println(maxProfit2(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit3(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit4(new int[]{1, 2, 3, 4, 5}));
    }


}