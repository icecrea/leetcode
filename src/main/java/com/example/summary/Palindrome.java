package com.example.summary;

import com.example.leetcode.dp.palindrome.*;
import org.junit.Test;

/**
 * @description: 回文系列
 * 判断整数回文数，最长回文子串，最长回文子序列，回文子串个数，分割回文串
 * @auther: icecrea
 * @date: 2020/4/27
 * @see com.example.leetcode.dp.palindrome
 */
public class Palindrome {

    /**
     * @see LeetCode05_LongestPalindromicSubstring 最长回文子串
     * @see LeetCode647_PalindromicSubstrings 回文子串个数
     * @see LeetCode009_isPalindrome 回文数
     * @see LeetCode131_PalindromePartitioning 分割回文串
     * @see LeetCode516_LongestPalindromicSubsequence 最长回文子序列
     *
     */

    /**
     * 最长回文子串
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = maxSubStr(s, i, i);
            String s2 = maxSubStr(s, i, i + 1);
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    private String maxSubStr(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    /**
     * 最长回文子串dp方法
     * 相当于填涂左上-右下对角线的右上部分
     */
    public String longestPalindrome2(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()]; //dp[1][5] 对应s1-5是否是回文串
        int max = 0, start = 0, end = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                //满足上述的第三个条件，即当前s.charAt(i)==s.charAt(j)并且s[i+1到j-1]也是回文串
                //j-i<2 是考虑单个字符/两个字符的回文串情况
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 回文子串个数
     */
    public int subPalindromeCount(String s) {
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

    /**
     * 最长回文子序列
     * 如 bbbab 对应最长回文子序列 bbbb
     * cbbd 对应 bb
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len]; //在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
        //遍历顺序： 保证每次计算dp[i][j] 左或下的位置已经被计算出来
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    /**
     * 是否回文数字
     */
    public boolean isPalindromeInteger(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertN = 0;
        while (x > revertN) {
            revertN = revertN * 10 + x % 10;
            x /= 10;
        }
        return x == revertN || x == revertN / 10;
    }


    @Test
    public void test() {
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("cbbd"));
    }


}
