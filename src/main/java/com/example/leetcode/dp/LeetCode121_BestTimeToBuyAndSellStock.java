package com.example.leetcode.dp;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class LeetCode121_BestTimeToBuyAndSellStock {

    /**
     * 可以将数组在xy坐标轴上画出，可以发现本题需要找到最小的谷和之后的最大的峰
     * 定义两个变量 minprice，maxprofit
     *
     * arr       7,1,5,3,6,4    7 2 6 1 3
     * minprice  7 1 1 1 1 1    7 2 2 1 1
     * maxprofit 0 0 4 4 5 5    0 0 4 4 4
     */
    public int maxProfit(int[] prices) {
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


    /**
     * 暴力法 O(n^2)，可以优化
     * 固定了买入时间 buy，然后将 buy 后面的每一天作为 sell 进行穷举，
     * 寻找 prices[sell] 最大的那天，因为这样 prices[sell] - prices[buy] 的差价才会最大。
     */
    public int maxProfit2(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxprofit = Math.max(maxprofit, prices[j] - prices[i]);
            }
        }
        return maxprofit;
    }

    /**
     * 对暴力法进行优化，只需要一次循环 O(n)
     * 反向思考：固定卖出时间 sell，向前穷举买入时间 buy，寻找 prices[buy] 最小的那天
     * 之前需要两层循环，是因为当每次从一个集合中去掉一个数，不确定拿走的是否最大数，需要再次重新遍历找到最大数。因此暴力算法，每次向后一位，都要重新算最大值
     * 而假设知道最小值，每次新增数字，只需要比较新增值和最小值，就可以得到新的最小值。所以减少了一层循环。
     * 优化关键在于数字是添加还是减少。添加新数，可以根据已有值推出最新值。而减少不一定能推导出，需要重新遍历
     */
    public int maxProfit3(int prices[]) {
        int maxprofit = 0;
        int curMin = prices[0];
        for (int sell = 1; sell < prices.length - 1; sell++) {
            curMin = Math.min(curMin, prices[sell]);
            maxprofit = Math.max(maxprofit, prices[sell] - curMin);
        }
        return maxprofit;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfitDP(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
        // 1：用户手上持股所能获得的最大利润

        // 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
        // 状态转移方程：
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        // dp[i][1] = max(dp[i - 1][1], -prices[i])
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //因为只能交易一次，所以如果当前是持有股状态，必然是在当前进行买入
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }


}
