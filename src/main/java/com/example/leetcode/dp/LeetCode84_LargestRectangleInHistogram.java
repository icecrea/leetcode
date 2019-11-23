package com.example.leetcode.dp;

import org.junit.Test;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LeetCode84_LargestRectangleInHistogram {


    /**
     * 暴力 找两边第一个小于它的值
     * 找到左边值比当前小的下标left，右边值比当前小的下标right，得出以当前值为高度的最大矩形面积
     */
    public int largestRectangleArea(int[] h) {
        int res = 0, len = h.length;
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && h[left] >= h[i]) {
                left--;
            }
            while (right < len && h[right] >= h[i]) {
                right++;
            }
            res = Math.max(res, (right - left - 1) * h[i]);
        }
        return res;
    }


    /**
     * 参考：
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
     */
    public int largestRectangleArea2(int[] h) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < h.length; ++i) {
            while (stack.peek() != -1 && h[stack.peek()] >= h[i]) {
                Integer pop = stack.pop();
                max = Math.max(max, h[pop] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            Integer pop = stack.pop();
            max = Math.max(max, h[pop] * (h.length - stack.peek() - 1));
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{6, 7, 5, 2, 4, 5, 9, 3}));
        System.out.println(largestRectangleArea2(new int[]{6, 7, 5, 2, 4, 5, 9, 3}));
    }

}
