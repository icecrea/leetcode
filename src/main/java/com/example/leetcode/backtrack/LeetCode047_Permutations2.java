package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 全排列2（含有相同元素排列）
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/20
 */
public class LeetCode047_Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(res, track, nums, visited);
        return res;
    }

    /**
     * 和leetcode046思路相同，区别在重复元素处理
     * 递归中，给track添加元素时，看当前元素是否等于前一元素，如果相等且前一元素还没有被访问过，则跳过当前元素
     */
    public void backTrack(List<List<Integer>> res, List<Integer> track, int[] nums, boolean[] visited) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            track.add(nums[i]);
            backTrack(res, track, nums, visited);
            visited[i] = false;
            track.remove(track.size() - 1);
        }
    }


    @Test
    public void test() {
        //[[1, 1, 2], [1, 2, 1], [2, 1, 1]]
        //[[1, 1, 2], [1, 2, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 1, 1]]
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}
