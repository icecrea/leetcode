package com.example.topinterview.easy.dp;

import com.example.leetcode.dp.LeetCode121_BestTimeToBuyAndSellStock;

/**
 * @description: 买股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @author: icecrea
 * @create: 2019-03-18 15:59
 **/
public class array55_maxProfit {
    /**
     * 找到最小的谷和之后的最大的峰
     * @see LeetCode121_BestTimeToBuyAndSellStock
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxprofit = 0;
        int curMin = prices[0];
        for (int sell = 1; sell < prices.length; sell++) {
            curMin = Math.min(curMin, prices[sell]);
            maxprofit = Math.max(maxprofit, prices[sell] - curMin);
        }
        return maxprofit;
    }
}
