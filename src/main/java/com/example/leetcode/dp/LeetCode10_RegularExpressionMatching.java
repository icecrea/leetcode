package com.example.leetcode.dp;

/**
 * @description: 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * @author: icecrea
 * @create: 2019-11-11
 **/
public class LeetCode10_RegularExpressionMatching {

    public boolean isMatch(char[] s, char[] p) {
        if (s == null || p == null) {
            return false;
        }
        return match(0, 0, s, p);
    }

    /**
     * 递归思路1：
     * 先判断模式串下一个是否*，再判断是否当前匹配
     */
    public boolean match(int i, int j, char[] s, char[] p) {
        //p遍历完了
        if (j == p.length) {
            //如果s也完了，返回true，不然false
            return i == s.length;
        }
        //模式串下一个是*
        if (j < p.length - 1 && p[j + 1] == '*') {
            //当前匹配
            if (i != s.length && (s[i] == p[j] || p[j] == '.')) {
                return match(i + 1, j, s, p) //字符后移1位，模式不变，因为*可以匹配多位 aaac a*c
                        || match(i, j + 2, s, p);//字符串不变，模式后移2位，相当于a*被忽略，代表出现零次的情况 ac 和 ab*c
            } else {
                //当前不匹配 跳过该模式 如 abc ad*c
                return match(i, j + 2, s, p);
            }
        }

        //模式串下一个不是* 当前匹配
        if (i != s.length && (s[i] == p[j] || p[j] == '.')) {
            return match(i + 1, j + 1, s, p);
        }
        return false;
    }


    /**
     * 递归思路2：
     * 先判断当前是否匹配，再判断模式串下一个是否*
     */
    private boolean match1(int i, int j, char[] s, char[] p) {
        if (j == p.length) {//p遍历完了
            //如果s也完了，返回true，不然false
            return s.length == i;
        }
        //先看当前是否匹配
        boolean isMatch = (i != s.length) && (s[i] == p[j] || p[j] == '.');
        //下一个是*
        if (j < p.length - 1 && p[j + 1] == '*') {
            return match1(i, j + 2, s, p) //匹配0个情况，不考虑当前是否匹配
                    || (isMatch && match1(i + 1, j, s, p)); //当前匹配多个情况
        } else {
            //下一个不是*
            return isMatch && match1(i + 1, j + 1, s, p);
        }
    }


    public static boolean matchDP1(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[str.length][pattern.length] = true;
        //开始循环
        for (int i = str.length; i >= 0; i--) {//外循环：从空串开始匹配
            for (int j = pattern.length - 1; j >= 0; j--) {//内循环：从模式串最后一个字符开始匹配
                if (j < pattern.length - 1 && pattern[j + 1] == '*') {
                    //当前相等
                    if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                        dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
                    } else {//当前不等
                        dp[i][j] = dp[i][j + 2];
                    }
                } else {
                    //若不是"*",看当前是否相等
                    if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {//当前相等
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
