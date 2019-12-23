package com.example.leetcode.binarysearch;

/**
 * @description: 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *  
 * 示例 1：
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 * 输入：[0,2,1,0]
 * 输出：1
 *  
 * 提示：
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 * @auther: icecrea
 * @date: 2019/12/19
 */
public class LeetCode852_PeakIndexInMountainArray {
    /**
     * 利用该数组先增后减的特性，二分查找
     * 数组左部分满足 A[mid] < A[mid + 1]  右部分不满足。
     * 当A[mid] < A[mid + 1]时， mid肯定不是最大值索引，在右半区查找
     */
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length, mid;
        while (left < right) {
            mid = (left + right) >>> 1;
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
