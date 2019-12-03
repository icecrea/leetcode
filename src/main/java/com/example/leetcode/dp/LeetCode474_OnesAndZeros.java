package com.example.leetcode.dp;

import org.junit.Test;

/**
 * 一和零
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 注意:
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 *
 * 示例 1:
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 *
 *
 * 示例 2:
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 */
public class LeetCode474_OnesAndZeros {


    /**
     * 递归
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0 || (m == 0 && n == 0)) {
            return 0;
        }
        return dp(strs, strs.length - 1, m, n);
    }

    /**
     * 用m个0，n个1 拼出 strs[0,i] 的 最大个数
     */
    public int dp(String[] strs, int i, int m, int n) {
        if (i < 0) {
            return 0;
        }
        int zeros = 0;
        int ones = 0;
        String str = strs[i];
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        if (m >= zeros && n >= ones) {
            return Math.max(dp(strs, i - 1, m, n),
                    1 + dp(strs, i - 1, m - zeros, n - ones));
        }
        return dp(strs, i - 1, m, n);
    }

    /**
     * dp[i][j]表示有i个0和j个1时能组成的最多字符串的个数
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        String[] s1 = new String[]{"10", "0001", "111001", "1", "0"};
        String[] s2 = new String[]{"10", "0", "1"};
        System.out.println(findMaxForm(s1, 5, 3));
        System.out.println(findMaxForm(s2, 1, 1));
        System.out.println(findMaxForm2(s1, 5, 3));
        System.out.println(findMaxForm2(s2, 1, 1));
        /**
         *   0 1
         * 0
         * 1   1
         *
         */
    }

}
