package com.example.leetcode.dp;

import org.junit.Test;

/**
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class LeetCode64_MinimumPathSum {
    /**
     * 和上面两题类似，只不过规则是左边最短与上面最短比较。需要将最短路径值存储
     */
    public int minPathSum(int[][] a) {
        int row = a.length;
        int col = a[0].length;

        //存储最短路径值
        int[][] dp = new int[row][col];
        dp[0][0] = a[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + a[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int min = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                dp[i][j] = a[i][j] + min;
            }
        }
        return dp[row - 1][col - 1];
    }

    @Test
    public void test() {
        int[][] c = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(c));
    }
}
