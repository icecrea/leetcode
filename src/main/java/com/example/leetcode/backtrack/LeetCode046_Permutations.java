package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/20
 */
public class LeetCode046_Permutations {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(track, nums);
        return res;
    }

    void backtrack(List<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(track, nums);
            track.remove(track.size() - 1);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> track = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(track, res, visited, nums);
        return res;
    }

    void backtrack(List<Integer> track, List<List<Integer>> res, boolean[] visited, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            track.add(nums[i]);
            backtrack(track, res, visited, nums);
            visited[i] = false;
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test() {
        permute(new int[]{1, 2, 3});
        System.out.println(res);

        List<List<Integer>> lists = permute2(new int[]{1, 2, 3});
        System.out.println(lists);
    }
}

