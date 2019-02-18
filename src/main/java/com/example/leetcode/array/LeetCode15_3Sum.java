package com.example.leetcode.array;

import org.junit.Test;

import java.util.*;

/**
 * @description: 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @author: icecrea
 * @create: 2019-02-18 14:49
 **/
public class LeetCode15_3Sum {

    /**
     * 暴力 O n^3
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);

                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 排序数组，订好一个数位置，查询另外两个和等于-nums[i]的组合。
     * 因为数组已排序，可以从两边往中间寻找，根据大小调整位置。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    //过滤重复
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (nums[l] + nums[r] > sum) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int nums[] = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
            }
        }
    }
}
