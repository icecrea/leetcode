package com.example.summary.sortalgorithm;

/**
 * @description: 冒泡排序
 * @author: icecrea
 * @create: 2018-12-18 17:42
 **/
public class BubbleSort {
    /**
     * 核心思路：
     * 每一轮依次进行两两比较，将最大的数沉底
     * 外圈：因为只剩下一个数时不用再比较，所以共须循环n-1次;
     * 内圈：第一圈比较n个数，需要n-1次，最大数沉底，第二圈比较n-1个数，需要n-2次。在第i次排序中，比较次数n-i；总移动次数n(n-1)/2；
     * 稳定的排序算法
     */
    public static void bubbleSort(int[] a) {
        if (a.length <= 1) {
            return;
        }

        boolean flag = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (flag == false) {
                break;
            }
            flag = false;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
        }
    }


    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }

}
