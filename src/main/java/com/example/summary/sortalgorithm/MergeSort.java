package com.example.summary.sortalgorithm;

import org.junit.Test;

/**
 * @description: 归并排序
 * @author: icecrea
 * @create: 2018-12-18 17:29
 **/
public class MergeSort {
    public static void mergeArray(int[] a, int first, int mid, int last) {
        int[] temp = new int[last - first + 1];
        int i = first, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= last) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[first + i] = temp[i];
        }
    }

    public static void mergeSort(int[] a, int first, int last) {
        if (first >= last) {
            return;
        }
        int mid = first + ((last - first) >> 1);
        //左边有序
        mergeSort(a, first, mid);
        //右边有序
        mergeSort(a, mid + 1, last);
        //合并两个有序数列
        mergeArray(a, first, mid, last);
    }

    @Test
    public void test() {
        int a[] = new int[]{5, 1, 7, 88, 4};
        mergeSort(a, 0, 4);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
