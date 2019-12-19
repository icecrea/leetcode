package com.example.leetcode.binarysearch;

/**
 * @description: 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * @auther: icecrea
 * @date: 2019/12/18
 */
public class LeetCode004_MedianOfTwoSortedArrays {

    /**
     * 利用数组，但时间复杂度为m+n 高于题目要求
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] a = new int[len];
        int p = 0, q = 0, i = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] <= nums2[q]) {
                a[i++] = nums1[p++];
            } else {
                a[i++] = nums2[q++];
            }
        }
        if (p < nums1.length) {
            while (i < len) {
                a[i++] = nums1[p++];
            }
        }
        if (q < nums2.length) {
            while (i < len) {
                a[i++] = nums2[q++];
            }
        }
        if ((len & 1) == 1) {
            return a[len / 2];
        } else {
            double d = a[len / 2] + a[len / 2 - 1];
            return d / 2;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays2(nums2, nums1);
        int k = (n1 + n2 + 1) / 2;
        int left = 0;
        int right = n1;
        while (left < right) {
            int m1 = left + (right - left) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                left = m1 + 1;
            else
                right = m1;
        }
        int m1 = left;
        int m2 = k - left;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((n1 + n2) % 2 == 1)
            return c1;
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;

    }


}
