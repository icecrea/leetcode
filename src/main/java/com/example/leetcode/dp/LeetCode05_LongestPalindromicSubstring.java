package com.example.leetcode.dp;

import org.junit.Test;

/**
 * @description: 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
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
     * TODO dp方法
     * dp[i][j] str[i] - str[j]是否是回文子串
     * dp[i][j] = dp[i+1][j-1] && str[i]==str[j]
     * 初始化：对角线为单个字符，设为0
     * 初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推
     */
    public String longestPalindrome2(String s) {
        //  长度为1，返回当前串
        if (s.length() == 1) {
            return s;
        }
        //长度为2并且两个字符相等则返回
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }
        //用于标记dp[j][i]即从j到i是否是回文串；
        //如dp[1][5]＝＝true则表示字符串索引位置从1到5的子串是回文串。
        boolean[][] dp = new boolean[s.length()][s.length()];
        //最长回文串初始最大为0
        int maxlen = 0;
        //对应的maxlen的开始索引位置
        int beginIndex = 0;
        //对应的maxlen的结束索引位置
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j >= 0) {
                //满足上述的第三个条件，即当前s.charAt(i)==s.charAt(j)并
                //且s[j＋1到i－1]也是回文串
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (maxlen < i - j + 1) {
                        beginIndex = j;
                        lastIndex = i + 1;
                        maxlen = i - j + 1;
                    }
                }
                j--;
            }
        }
        return s.substring(beginIndex, lastIndex);
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println("01234".substring(1, 3));
    }

}
