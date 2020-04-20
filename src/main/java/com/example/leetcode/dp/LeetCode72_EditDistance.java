package com.example.leetcode.dp;

import org.junit.Test;

/**
 * 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class LeetCode72_EditDistance {

    public int minDistance(String word1, String word2) {
        return dp(word1.toCharArray(), word2.toCharArray(), word1.length() - 1, word2.length() - 1);
    }

    /**
     * 递归方法，超时
     * 方便理解可以先看下LCS问题 对于字符串动态规划设置双指针从后往前遍历
     *
     * @see LeetCode1143_LCS
     * 核心操作3种，增删换，构建状态转移方程
     * 注意结束条件，指针i或者j遍历结束，如果另一方没结束，相当于添加/删除另一方剩余长度。
     */
    public int dp(char[] s1, char[] s2, int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (s1[i] == s2[j]) {//跳过
            return dp(s1, s2, i - 1, j - 1);
        } else {
            return min(dp(s1, s2, i, j - 1) + 1, dp(s1, s2, i - 1, j) + 1, dp(s1, s2, i - 1, j - 1) + 1);
        }
    }

    /**
     * dp数组优化
     * dp(i, j)对应s1[0..i] 和 s2[0..j] 的最小编辑距离
     * dp[..][0]和dp[0][..]对应 basecase
     */
    public int minDistance2(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        //注意是下标从1开始
        for (int i = 1; i <= s1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= s2.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[s1.length][s2.length];
    }

    @Test
    public void test() {
        System.out.println(minDistance("rad", "apple"));
        System.out.println(minDistance2("rad", "apple"));
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
