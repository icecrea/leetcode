package com.example.leetcode.dp;

import org.junit.Test;

/**
 * @description: 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @author: icecrea
 * @create: 2019-11-11
 **/
public class LeetCode05_LongestPalindromicSubstring {

    /**
     * 中心扩散法
     * 利用双指针，同时处理回文串长度为奇数和偶数的情况
     * 时间复杂度 O(N^2)，空间复杂度 O(1)
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String s, int l, int r) {
        //防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            //向两边展开
            l--;
            r++;
        }
        //返回以s[l]和s[r]为中心的最长回文串
        return s.substring(l + 1, r);
    }

    /**
     * 动态规划方法
     * dp[i][j] str[i] - str[j]是否是回文子串
     * dp[i][j] = dp[i-1][j+1] && str[i]==str[j]
     * 初始化：对角线为单个字符，设为0
     * 初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推
     */
    public String longestPalindrome2(String s) {
        if (s.length() == 0) {
            return s;
        }
        //用于标记dp[i][j]即从i到j是否是回文串，如dp[1][5]＝＝true则表示字符串索引位置从1到5的子串是回文串。
        boolean dp[][] = new boolean[s.length()][s.length()];
        int max = 0, start = 0, end = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                //满足上述的第三个条件，即当前s.charAt(i)==s.charAt(j)并且s[j＋1到i－1]也是回文串
                //j-i<2 是考虑单个字符+两个字符的回文串情况
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

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println("01234".substring(1, 3));
    }

}
