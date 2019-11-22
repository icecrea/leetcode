package com.example.leetcode.dp;

import org.junit.Test;

/**
 * 不同路径2
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class LeetCode63_UniquePaths2 {

    /**
     * 推导公式同62  注意特殊值的判断
     */
    public int uniquePathsWithObstacles(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        for (int i = 0; i < dp.length; i++) {
            if (a[i][0] == 1) {
                dp[i][0] = 0;
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (a[0][i] == 1) {
                dp[0][i] = 0;
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[a.length - 1][a[0].length - 1];
    }

    @Test
    public void test() {
        int[][] a = new int[1][1];
        a[0][0] = 1;
        System.out.println(uniquePathsWithObstacles(a));

        int[][] b = new int[1][2];
        b[0][0] = 1;
        b[0][1] = 0;
        System.out.println(uniquePathsWithObstacles(b));

        int[][] c = {{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(c));
    }
}
