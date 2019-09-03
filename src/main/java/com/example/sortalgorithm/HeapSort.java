package com.example.sortalgorithm;

import org.junit.Test;

/**
 * @description: 堆排序
 * @author: icecrea
 * @create: 2018-12-18 17:37
 **/
public class HeapSort {

    /**
     * 筛选法调整堆算法 将以LOW为根节点的子树调整成小顶堆
     *
     * @param a
     * @param low
     * @param high
     */
    public static void sift(int[] a, int low, int high) {
        int i = low;
        int j = 2 * i + 1;
        int temp = a[i];
        while (j < high) {
            if (j < high - 1 && a[j] > a[j + 1]) {
                j++;
            }
            //若父母结点值较大
            if (temp > a[j]) {
                //孩子节点中较小值上移
                a[i] = a[j];
                i = j;
                j = 2 * i + 1;
            } else {
                //退出循环
                j = high + 1;
            }
        }
        a[i] = temp;
    }

    /**
     * 重在理解筛选法调整堆 通过它构造堆 和 调整堆
     * 每次通过每次构造小顶堆获得最小值，依次获得有序序列
     * 为无序序列创建堆的时候时堆完全二叉树从下往上筛选，最后一个非叶子节点编号[n/2]-1
     * 时间复杂度最坏情况O(n*log2n) 不稳定的排序算法
     */
    public static void heapSort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            sift(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            sift(a, 0, i);
        }
    }

    /**
     * 5
     * 4   3
     * 21
     *
     * 3
     * 4   5
     * 21
     *
     */
    @Test
    public void test(){
        int a[] = new int[]{5,4,3,2,1};
        sift(a, 0, 5);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        int a[] = new int[]{1,2,3,4,5};
        heapSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
