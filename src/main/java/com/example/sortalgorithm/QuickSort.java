package com.example.sortalgorithm;

import org.junit.Test;

/**
 * @description: 快速排序
 * <p>
 * 核心在于分区操作
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

    /**
     * // 快速排序，A 是数组，n 表示数组的大小
     * quick_sort(A, n) {
     * quick_sort_c(A, 0, n-1)
     * }
     * // 快速排序递归函数，p,r 为下标
     * quick_sort_c(A, p, r) {
     * if p >= r then return
     * <p>
     * q = partition(A, p, r) // 获取分区点
     * quick_sort_c(A, p, q-1)
     * quick_sort_c(A, q+1, r)
     * }
     */
    public void quickSortGT(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        //获取分区点
        int q = partitionGT(a, p, r);
        quickSortGT(a, p, q - 1);
        quickSortGT(a, q + 1, r);
    }

    /**
     * TODO 可以优化，利用哨兵，减少交换次数
     * <p>
     * 伪代码：
     * partition(A, p, r) {
     * pivot := A[r]
     * i := p
     * for j := p to r-1 do {
     * if A[j] < pivot {
     * swap A[i] with A[j]
     * i := i+1
     * }
     * }
     * swap A[i] with A[r]
     * return i
     *
     * 通过游标 i 把 A[p…r-1] 分成两部分。A[p…i-1] 的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，A[i…r-1] 是“未处理区间”。
     * 我们每次都从未处理的区间 A[i…r-1] 中取一个元素 A[j]，与 pivot 对比，如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i] 的位置。
     *
     *
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

    @Test
    public void test1() {
        int a[] = new int[]{5, 1, 7, 88, 4};
        quickSort(a, 0, 4);
        for (int i : a) {
            System.out.println(i);
        }

        int b[] = new int[]{5, 1, 7, 88, 4};
        quickSortGT(b, 0, 4);
        for (int i : b) {
            System.out.println(i);
        }
    }

}
