package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 求子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/20
 */
public class LeetCode078_Subsets {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> backtrack = new ArrayList<>();
        backtrack(nums, 0, backtrack, res);
        return res;
    }

    /**
     * https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/zi-ji-pai-lie-zu-he
     *
     * @param nums
     * @param start 通过start
     * @param track
     */
    public void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> res) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track, res);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtrack(0, size, new ArrayList<>(), res, nums);
        }
        return res;
    }

    private void backtrack(int start, int size, ArrayList<Integer> track, List<List<Integer>> res, int[] nums) {
        if (track.size() == size) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(i + 1, size, track, res, nums);
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{1, 2, 2}));
        System.out.println(subsets2(new int[]{1, 2, 3}));
        System.out.println(subsets2(new int[]{1, 2, 2}));
    }


}
