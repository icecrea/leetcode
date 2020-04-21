package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 子集2
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/20
 */
public class LeetCode090_Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length; size++) {
            backtrack(0, size, new ArrayList<>(), res, nums, visited);
        }
        return res;
    }

    private void backtrack(int start, int size, ArrayList<Integer> track, List<List<Integer>> res, int[] nums, boolean[] visited) {
        if (track.size() == size) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //设置标记数组，标记是否访问过，如果当前元素与前一个元素相等且前一元素没有处理过，则跳过当前元素
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            track.add(nums[i]);
            backtrack(i + 1, size, track, res, nums, visited);
            visited[i] = false;
            track.remove(track.size() - 1);
        }
    }


    @Test
    public void test() {
//        System.out.println(subsetsWithDup(new int[]{1, 2, 3}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
