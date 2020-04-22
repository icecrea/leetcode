package com.example.leetcode.dp;

/**
 * 买卖股票的最佳时机3
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class LeetCode123_BestTimeToBuyAndSellStock3 {

    /**
     * 原始的动态转移方程，没有可化简的地方
     * 第 i 天，第 k 笔， 1持有，0不持有
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * 参考：
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        // 初始化 dp 数组,第 i 天，第 k 笔 交易，是否持有股票,1 持有，0 不持有
        int[][][] mp = new int[prices.length][3][2];
        // 初始化第一天数据，买入股票
        for (int i = 1; i <= 2; i++) {
            mp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2; j++) {
                // 第 i 天，第 j 笔 交易，不持有股票的最大值=
                // 前一天持有股票今天卖出 / 前一天不持有股票，保持不变
                mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                // 第 i 天，第 j 笔 交易，持有股票的最大值=
                // 前一天不持有股票今天买入 / 前一天持有股票，保持不变
                mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return mp[prices.length - 1][2][0];
    }

}
