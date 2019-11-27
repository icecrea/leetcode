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

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println("01234".substring(1, 3));
    }
}
