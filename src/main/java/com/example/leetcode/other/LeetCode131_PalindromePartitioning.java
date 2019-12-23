package com.example.leetcode.other;


import java.util.*;

/**
 * @description: 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * @auther: icecrea
 * @date: 2019/12/16
 */
public class LeetCode131_PalindromePartitioning {

    /**
     * 利用dp数组+递归的方式
     */
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return partitionHelper(s, 0, dp);
    }

    private List<List<String>> partitionHelper(String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                for (List<String> l : partitionHelper(s, i + 1, dp)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    /**
     * dp数组 + dfs 回溯法
     */
    public List<List<String>> partition2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        partitionHelper(s, 0, dp, new ArrayList<>(), res);
        return res;
    }

    private void partitionHelper(String s, int start, boolean[][] dp, List<String> temp, List<List<String>> res) {
        //到了空串就加到最终的结果中
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
        }
        //在不同位置切割
        for (int i = start; i < s.length(); i++) {
            //如果是回文串就加到结果中
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                temp.add(left);
                partitionHelper(s, i + 1, dp, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }


}
