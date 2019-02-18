package com.example.leetcode.array;

import org.junit.Test;

/**
 * @description: 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * @author: icecrea
 * @create: 2019-02-14 22:52
 **/
public class LeetCode4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] arr = new int[len / 2 + 1];
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (x < nums1.length && y < nums2.length) {
                if (nums1[x] <= nums2[y]) {
                    arr[i] = nums1[x++];
                } else {
                    arr[i] = nums2[y++];
                }
            } else if (x >= nums1.length) {
                arr[i] = nums2[y++];
            } else if (y >= nums2.length) {
                arr[i] = nums1[x++];
            }
        }
        if (len % 2 != 0) {
            return arr[arr.length - 1];
        } else {
            return (arr[arr.length - 1] + arr[arr.length - 2]) / 2.0;
        }
    }


    /**
     * 不使用数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int x = 0;
        int y = 0;
        int mid = 0;
        int tmp = 0;
        for (int i = 0; i < len / 2 + 1; i++) {
            tmp = mid;
            if (x < nums1.length && y < nums2.length) {
                if (nums1[x] <= nums2[y]) {
                    mid = nums1[x++];
                } else {
                    mid = nums2[y++];
                }
            } else if (x >= nums1.length) {
                mid = nums2[y++];
            } else if (y >= nums2.length) {
                mid = nums1[x++];
            }
        }

        if (len % 2 != 0) {
            return mid;
        } else {
            return (mid + tmp) / 2.0;
        }
    }

}
