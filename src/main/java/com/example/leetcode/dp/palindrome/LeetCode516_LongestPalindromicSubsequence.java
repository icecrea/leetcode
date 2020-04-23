package com.example.leetcode.dp.palindrome;

import org.junit.Test;

/**
 * 最长回文子序列
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 */
public class LeetCode516_LongestPalindromicSubsequence {

    /**
     * dp[i][j] : 在子串 s[i..j] 中，最长回文子序列的长度
     * 我们需要的是 dp[0][n - 1]
     * 注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = n - 1; i >= 0; i--) {
            //单个字符初始化 回文为1
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    @Test
    public void test(){

        /**
         *
         *   b b b a b
         * b 1
         * b   1
         * b     1
         * a       1
         * b         1
         */

        System.out.println(longestPalindromeSubseq("bbbab"));
    }

}
