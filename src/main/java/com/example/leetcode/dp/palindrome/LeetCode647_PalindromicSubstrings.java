package com.example.leetcode.dp.palindrome;

import org.junit.Test;

/**
 * @description: 回文子串个数
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 * 输入的字符串长度不会超过1000。
 * @auther: icecrea
 * @date: 2019/12/16
 */
public class LeetCode647_PalindromicSubstrings {
    /**
     * 动态规划
     * dp[i][j] 代表str[i] - str[j]是否是回文子串
     * 考虑单字符和双字符的特殊情况
     * 状态转移方程：dp[i][j] = dp[i+1][j-1] && str[i]==str[j]
     * 可以类比
     * @see LeetCode05_LongestPalindromicSubstring
     */
    public int countSubstrings(String s) {
        int res = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("abc"));
    }
}
