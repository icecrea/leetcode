package com.example.weeklycontest.weeklycontest132;

/**
 * @description: 最长等差数列
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 * <p>
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
 * 并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 * <p>
 * 输入：[9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 * <p>
 * 输入：[20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 * @author: icecrea
 * @create: 2019-04-17 10:41
 **/
public class LongestArithmeticSequence {

    /**
     *
     * ！！！！！！！！！！！！
     *
     * dp[i][d]表示以i结尾的公差为d的最大长度: dp[i][d] = dp[j][d] + 1(j < i)
     *
     * d可能为负数，加个值修正一下。
     * @param A
     * @return
     */
    public int longestArithSeqLength(int[] A) {
        int ans = 2;
        int n = A.length;
        int diff = 10000;
        int[][] dp = new int[10010][20010];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];
                int ddiff = d + diff;
                if (dp[j][ddiff] == 0) {
                    dp[i][ddiff] = 2;
                } else {
                    dp[i][ddiff] = dp[j][ddiff] +1;
                }
                ans = Math.max(ans, dp[i][ddiff]);
            }
        }
        return ans;
    }
}
