package com.example.leetcode.dp;

import java.util.Arrays;

/**
 * @description: 跳跃游戏2
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/22
 */
public class LeetCode45_JumpGame2 {
    //保存全局变量 表示当前的最小跳跃数
    private int minCount = Integer.MAX_VALUE;

    /**
     * 回溯 超时
     * 能跳的都跳了
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        backtrack(nums, 0, 0);
        return minCount;
    }

    public void backtrack(int[] a, int index, int count) {
        //递归终止条件 表示已经跳到了最后一个位置
        if (index >= a.length - 1) {
            minCount = Math.min(minCount, count);
            return;
        }
        int step = a[index];
        for (int i = 1; i <= step; i++) {
            backtrack(a, index + i, count + 1);
        }
    }

    /**
     * dp[i] 走到nums[i]位置最少需要的步数
     * 遍历[0,i-1] 找到能到达位置i的 同时步骤数又是最小的
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length + 1);
        dp[0] = 0;//一开始就在第一个位置
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                //判断能到达i这个位置
                if (nums[j] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }


    /**
     * 贪心算法 最优解
     * 2,3,1,1,4
     * 2,4,4,4
     * i和end标记了可以选择的跳跃步数，farthest标记了所有可选择跳跃步数[i..end]中能够跳到的最远距离，jumps记录了跳跃次数。
     */
    int jump3(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            //每次更新跳到的最远距离
            farthest = Math.max(nums[i] + i, farthest);
            //走到end时候，将end置为最远距离farthest
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

}
