package com.example.summary.sortalgorithm;

import org.junit.Test;

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
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }
    }


    @Test
    public void test() {
        int a[] = new int[]{5, 1};
        insertionSort(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
