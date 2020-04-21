package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/20
 */
public class LeetCode077_Combinations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> backtrack = new ArrayList<>();
        backtrack(backtrack, k, n, 1);
        return res;
    }

    void backtrack(List<Integer> track, int k, int n, int start) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(track, k, n, i + 1);
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test() {
        combine(4, 2);
        System.out.println(res);
    }
}
