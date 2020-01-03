package com.example.leetcode.other;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 滑动窗口中位数
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给出一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 * 例如：
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 * 提示：
 * 假设k是合法的，即：k 始终小于输入的非空数组的元素个数.
 * @author: icecrea
 * @create: 2020-01-03
 **/
public class LeetCode480_SlidingWindowMedian {
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] arr = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                remove(nums[i - k]);
            }
            add(nums[i]);
            if (i >= k - 1) {
                buildMidArray(arr, k, i);
            }
        }
        return arr;
    }


    /**
     * 注意这里移动回大根堆的条件：
     * minheap.size() > maxheap.size()
     * 因为当删除操作之后，大根堆和小根堆的数量有可能会存在 2-3 或者 4-2这种情况
     */
    private void add(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if(minheap.size() > maxheap.size()){
            maxheap.add(minheap.poll());
        }
    }

    private void remove(int num) {
        if (maxheap.peek() >= num) {
            maxheap.remove(num);
        } else {
            minheap.remove(num);
        }
    }

    private void buildMidArray(double[] arr, int k, int i) {
        if ((k & 1) == 1) {
            arr[i - k + 1] = maxheap.peek();
        } else {
            double sum = (double) maxheap.peek() + minheap.peek();
            arr[i - k + 1] = sum / 2;
        }
    }

    @Test
    public void test() {
//        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
//        medianSlidingWindow(ints, 3);
//        medianSlidingWindow(new int[]{1, 4, 2, 3}, 4);
        medianSlidingWindow(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 4);
    }

}
