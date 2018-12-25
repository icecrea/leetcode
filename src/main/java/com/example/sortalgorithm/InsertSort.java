package com.example.sortalgorithm;

/**
 * @description: 直接插入排序
 * @author: icecrea
 * @create: 2018-12-18 17:41
 **/
public class InsertSort {
    /**
     * 核心思路：每次将一条数据插入到有序序列中，将大于该数字的数据统一后移一位，形成新的有序序列。重复到全部有序。（顾名思义）
     * 监视哨：无需重复判断数组下标是否越界，将每个a[i]赋给a[0]，当比较到0个位置时自动成立退出循环
     * 稳定的排序算法
     */
    public static void insertSort(int[] a) {
        int i, j;
        for (i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = temp;
            }
        }
    }
}
