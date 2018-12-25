package com.example.sortalgorithm;

/**
 * @description: 直接选择排序
 * @author: icecrea
 * @create: 2018-12-18 17:38
 **/
public class SelectSort {
    /**
     * 思路：每一圈比较获得最小值的下标，并付给当前数组的第一位。
     * 时间复杂度：外循环n-1次，内圈循环n-1-i次 O(n^2)
     * 不稳定的排序算法
     */
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    //找到最小值的下标
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
