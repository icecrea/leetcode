package com.example.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * @author: icecrea
 * @create: 2019-11-02
 **/
public class LeetCode18_4Sum {

    /**
     * 通过每一位和前一位比较是否相同，来判断重复 时间复杂度o(n^3)
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            //与上一位相同,则后面都会重复,跳过 注意i>0防止空指针
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                //同理，跳过重复
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int curr = nums[i] + nums[j] + nums[l] + nums[r];
                    if (curr == target) {
                        List<Integer> t = addList(nums, i, j, l, r);
                        res.add(new ArrayList<>(t));
                        l++;
                        r--;
                        //过滤重复
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        //过滤重复
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (curr > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }

    private List<Integer> addList(int[] nums, int i, int j, int l, int r) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[i]);
        list.add(nums[j]);
        list.add(nums[l]);
        list.add(nums[r]);
        return list;
    }

}
