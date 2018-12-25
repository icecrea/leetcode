package com.example.sortalgorithm;

/**
 * @description: 希尔排序
 * @author: icecrea
 * @create: 2018-12-18 17:39
 **/
public class ShellSort {
    /**
     * 又称缩小增量排序。
     * 直接插入排序的优化，利用直接插入排序N较小时效率高与N基本有序时效率高的特点，将数据分组进行直接插入排序。\
     * 不稳定的排序算法
     * @param a
     */
    public static void shellSort(int[] a) {
        int step = a.length / 2;
        int i, j;
        while (step > 0) {
            for (i = step; i < a.length; i++) {
                int temp = a[i];
                for (j = i - step; j >= 0 && a[j] > temp; j -= step) {
                    a[j + step] = a[j];
                }
                a[j + step] = temp;
            }
            step = step / 2;
        }
    }
}
