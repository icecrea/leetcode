package com.example.sortalgorithm;

/**
 * @description: 快速排序
 * @author: icecrea
 * @create: 2018-12-18 17:42
 **/
public class QuickSort {
    /**
     * 以a[0]为基准数，将比这个数小的放左边，比这个数大的放右边
     */
    public static int partition(int[] a, int low, int high) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            if (low < high) {
                a[low] = a[high];
                low++;
            }
            while (low < high && a[low] < temp) {
                low++;
            }
            if (low < high) {
                a[high] = a[low];
                high--;
            }
        }
        a[low] = temp;
        return low;
    }

    /**
     * 核心思路：
     * 1.先从数列中取出一个数作为基准数。
     * 2.分区过程，将比这个数大的放左边，比这个数小的放右边。
     * 3.在对左右区间重复第二步，直到各区间只有一个数
     * 不稳定的排序算法
     */
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int i = partition(a, low, high);
            quickSort(a, low, i);
            quickSort(a, i + 1, high);
        }
    }
}
