package com.example.topinterview.easy.sort;

import org.junit.Test;

/**
 * @description: 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 * @author: icecrea
 * @create: 2019-03-18 14:31
 **/
public class array52_merge {
    /**
     * 真的蠢 没脑子 打脸
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for(int i =0;i<nums2.length;i++){
                nums1[i]=nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        for (int last = m + n - 1; last >= 0; last--) {
            if (j == -1 || i == -1) {
                break;
            }
            if (nums2[j] >= nums1[i]) {
                nums1[last] = nums2[j];
                j--;
            } else {
                nums1[last] = nums1[i];
                i--;
            }
        }
        if (i == -1 && j != -1) {
            for (int x = 0; x <= j; x++) {
                nums1[x] = nums2[x];
            }
        }

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while(i >=0 && j>=0)
        {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }
        while(j>=0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * [1,2,4,5,6,0]
     * 5
     * [3]
     * 1
     */
    @Test
    public void test(){
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
    }
}
