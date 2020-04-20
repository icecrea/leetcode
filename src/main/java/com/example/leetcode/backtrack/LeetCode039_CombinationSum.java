package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.*;

/**
 * @description: 组合总数
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/3/11
 */
public class LeetCode039_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(track, res, 0, candidates, target);
        return res;
    }

    private void backtrack(List<Integer> track, List<List<Integer>> res, int start, int[] nums, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] <= target) {
                    track.add(nums[i]);
                    backtrack(track, res, i, nums, target - nums[i]);
                    track.remove(track.size() - 1);
                }
            }
        }
    }

    @Test
    public void test() {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }


}
