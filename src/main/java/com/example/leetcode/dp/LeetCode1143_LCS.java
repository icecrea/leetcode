package com.example.leetcode.dp;

import org.junit.Test;

/**
 * 最长公共子序列 LCS问题 LongestCommonSubsequence
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * 示例 2:
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 *
 * 示例 3:
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 */
public class LeetCode1143_LCS {

    public int longestCommonSubsequence(String text1, String text2) {
        return dp(text1.toCharArray(), text2.toCharArray(), text1.length() - 1, text2.length() - 1);
    }

    /**
     * 递归思路，会超时
     *
     * 如果s1[i]==s2[j],即s1最后元素和s2最后元素相同，那么该元素一定在公共子序列中，所以需要找到lcs(i-1,j-1),将其拆解为子问题。
     *
     * 两个指针i和j从后往前遍历s1和s2，若s1[i]==s2[j]，这个字符一定在lcs中；
     * 否则，s1[i]和s2[j]这两个字符至少有一个不在lcs中，需要丢弃一个
     */
    public int dp(char[] s1, char[] s2, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (s1[i] == s2[j]) {
            return dp(s1, s2, i - 1, j - 1) + 1;
        } else {
            return Math.max(dp(s1, s2, i - 1, j), dp(s1, s2, i, j - 1));
        }
    }

    /**
     * 结合递归思路，通过dp数组优化时间复杂度
     * dp数组定义：对于s1[1..i]和s2[1..j]，它们的 LCS 长度是dp[i][j]
     * dp[i][j] = dp[i-1][j-1] + 1;
     * dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
     *
     *     a b c d e
     *   0 0 0 0 0 0
     * a 0 1
     * c 0
     * e 0
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int dp[][] = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }

    @Test
    public void test() {
        System.out.println(longestCommonSubsequence2("abcde", "ace"));
    }

}
