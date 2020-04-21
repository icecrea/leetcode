package com.example.leetcode.backtrack;


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
     * dp数组 + dfs 回溯法
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
        List<List<String>> res = new ArrayList<>();
        partitionHelper(s, 0, dp, new ArrayList<>(), res);
        return res;
    }

    private void partitionHelper(String s, int start, boolean[][] dp, List<String> track, List<List<String>> res) {
        //到了空串就加到最终的结果中
        if (start == s.length()) {
            res.add(new ArrayList<>(track));
        }
        //在不同位置切割
        for (int i = start; i < s.length(); i++) {
            //如果是回文串就加到结果中
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                track.add(left);
                partitionHelper(s, i + 1, dp, track, res);
                track.remove(track.size() - 1);
            }
        }
    }

    /**
     * 回溯法
     * @param s
     * @return
     */
    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> track, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(track));
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (isPalindrome(s, i)) {
                    track.add(s.substring(0, i + 1));
                    backtrack(res, track, s.substring(i + 1));
                    track.remove(track.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int end) {
        int start = 0;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


}
