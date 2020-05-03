package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 组合总和2
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/3/11
 */
public class LeetCode040_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, res, list);

        return res;
    }


    //1 1 2 5 6 7 10
    private void backTrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> track) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // [[1,1,6],[1,2,5],[1,7],[2,6]] 预期
            // [[1,1,6],[1,2,5],[1,7],[1,2,5],[1,7],[2,6]] 不加下面判断结果
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, res, track);
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test() {
        //1 1 2 5 6 7 10
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(combinationSum2(new int[]{1,1,6}, 7));
    }


}
