package com.example.summary;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 单调栈类问题
 * 参考： https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/dan-tiao-zhan
 * @auther: icecrea
 * @date: 2020/4/24
 */
public class MonotoneStack {

    /**
     * 找到数组右侧第一个比它大的数字
     * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]
     *
     * @param nums
     * @return
     */
    public int[] findRightFirstLargerNumber(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        //从后往前
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();//弹出矮个元素
            }
            //此时栈中存着i右侧比nums[i]大的元素 因为是从右往左入栈，所以从左往右出栈 即右侧第一个比它大的数字
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);//进队
        }
        return res;
    }

    /**
     * 返回数组到下一个比它大的位置的距离
     * 数组 T = [73, 74, 75, 71, 69, 72, 76, 73]，返回 [1, 1, 4, 2, 1, 1, 0, 0]。
     */
    public int[] findRightFirstLargerDistance(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        //从后往前
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();//弹出矮个元素
            }
            //此时栈中存着i右侧比nums[i]大的元素 因为是从右往左入栈，所以从左往右出栈 即右侧第一个比它大的数字
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);//进队
        }
        return res;
    }

    /**
     * 假设给的是一个环形数组，求数组右侧第一个比它大的数字
     * 如 给出 [2,1,2,4,3]，你返回数组 [4,2,4,-1,4]
     *
     * @param nums
     * @return
     */
    public int[] findRightFirstLargerCircle(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        //从后往前
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % len]) {
                stack.pop();//弹出矮个元素
            }
            //此时栈中存着i右侧比nums[i]大的元素 因为是从右往左入栈，所以从左往右出栈 即右侧第一个比它大的数字
            res[i % len] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(nums[i % len]);//进队
        }
        return res;
    }


    @Test
    public void test() {
        int[] a = findRightFirstLargerNumber(new int[]{1, 5, 3, 6, 4, 8, 9, 10});
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] res = findRightFirstLargerDistance(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] aaa = findRightFirstLargerCircle(new int[]{2, 1, 2, 4, 3});
        for (int i : aaa) {
            System.out.print(i + " ");
        }
    }
}
