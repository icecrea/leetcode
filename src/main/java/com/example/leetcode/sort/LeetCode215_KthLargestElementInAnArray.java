package com.example.leetcode.sort;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 数组中第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @author: icecrea
 * @create: 2019-04-10 18:34
 **/
public class LeetCode215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        k = nums.length - k + 1;
        while (l <= r) {
            int mid = partition(nums, l, r);
            if (mid == k - 1) {
                return nums[mid];
            }
            if (mid < k - 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    private int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.poll();
    }

    @Test
    public void test() {
        // 1 2 5 6 7 34
        // 6 5 7 34 2 1
//        int[] a =new int[]{4,9,1,5,7,34,2,6};
//        int[] a = new int[]{9 ,3, 2, 1, 5, 6, 4};
        //1 2 2 3 3 4 5 5 6
        int[] a = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int[] a = new int[]{5, 4, 3, 2, 3, 1, 2, 5, 6};
        int partition = partition(a, 0, a.length - 1);
        System.out.println(partition);
        System.out.println("------------");


        int kthLargest = findKthLargest(a, 3);
        System.out.println(kthLargest);
        System.out.println("---------------");
        for (int q : a) {
            System.out.println(q);
        }
    }

}
