package com.example.leetcode.other;

import org.junit.Test;

/**
 * @description: 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/20
 */
public class LeetCode042_RainWater {
    /**
     * water[i] = min(max(height[0...i]), max(height[i...end])) - height[i];
     * 参考： https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/jie-yu-shui
     * 1.暴力法
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int lMax = 0, rMax = 0;
            for (int j = i; j < height.length; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            for (int j = i; j >= 0; j--) {
                lMax = Math.max(lMax, height[j]);
            }
            res += Math.min(lMax, rMax) - height[i];
        }
        return res;
    }

    /**
     * 时间复杂度优化为O(n)：用数组保存lmax, rmax 不用每次计算
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length, res = 0;
        int[] lMax = new int[len];
        int[] rMax = new int[len];
        lMax[0] = height[0];
        rMax[len - 1] = height[len - 1];
        //从左往右
        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }
        //从右往左
        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(trap2(new int[]{2, 0, 2}));
    }
}
