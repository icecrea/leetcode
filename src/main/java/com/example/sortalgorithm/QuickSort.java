package com.example.sortalgorithm;

import org.junit.Test;

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
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) {
                high--;
            }
            if (low < high) {
                a[low] = a[high];
                low++;
            }
            while (low < high && a[low] < pivot) {
                low++;
            }
            if (low < high) {
                a[high] = a[low];
                high--;
            }
        }
        a[low] = pivot;
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

    @Test
    public void test1() {
        int a[] = new int[]{5, 1, 7, 88, 4};
        quickSort(a, 0, 4);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        int a[] = new int[]{5, 1, 7, 88, 4};
        quickSortGT(a, 0, 4);
        for (int i : a) {
            System.out.println(i);
        }
    }


    public void quickSortGT(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        //获取分区点
        int q = partitionGT(a, p, r);
        quickSortGT(a, p, q);
        quickSortGT(a, q + 1, r);
    }

    /**
     * 可以优化，利用哨兵，减少交换次数
     *
     * @param a
     * @param p
     * @param r 最后一位下标
     */
    public int partitionGT(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i++;
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

}
