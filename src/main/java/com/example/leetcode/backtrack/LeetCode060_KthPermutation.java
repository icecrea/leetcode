package com.example.leetcode.backtrack;

import org.junit.Test;

/**
 * @description: 第K个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: icecrea
 * @create: 2020-05-03
 **/
public class LeetCode060_KthPermutation {


    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        int[] factorial = new int[n + 1];//阶乘数组
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        StringBuilder track = new StringBuilder();
        backTrack(n, k, 0, track, visited, factorial);
        return track.toString();
    }


    /**
     * @param n
     * @param k
     * @param index     在这一步之前选择的数字个数
     * @param track
     * @param visited
     * @param factorial
     */
    void backTrack(int n, int k, int index, StringBuilder track, boolean[] visited, int[] factorial) {
        if (index == n) {
            return;
        }
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            //剪枝
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            visited[i] = true;
            track.append(i);
            backTrack(n, k, index + 1, track, visited, factorial);
            //每次剪枝，这样第一次到终点返回的就是结果。不需要在回溯了
//            visited[i] = false;
//            track.deleteCharAt(track.length() - 1);
        }
    }


    @Test
    public void test() {
        System.out.println(getPermutation(9, 1));
        System.out.println(getPermutation(9, 2));
        System.out.println(getPermutation(9, 3));
        System.out.println(getPermutation(9, 353955));

    }
}
