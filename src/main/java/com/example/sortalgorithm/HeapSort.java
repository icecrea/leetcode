package com.example.sortalgorithm;

import org.junit.Test;

/**
 * @description: 堆排序 只能从数组下标1开始计算，则左子节点为2i，右子节点为2i+1，父节点为i/2
 * @author: icecrea
 * @create: 2018-12-18 17:37
 **/
public class HeapSort {

    /**
     * 构建堆 从下标1到下标n
     * 从后往前处理数组，每个数据都是从上往下堆化
     */
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 堆化操作 将数组a中，以i开始，n结束的数组调整为大根堆
     */
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxIndex = i;
            if (i * 2 <= n && a[maxIndex] < a[i * 2]) {
                maxIndex = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxIndex] < a[i * 2 + 1]) {
                maxIndex = i * 2 + 1;
            }
            //已经是大根堆了
            if (maxIndex == i) {
                break;
            }
            swap(a, i, maxIndex);
            //指针i移动到maxIndex下标处，继续进行下层堆化
            i = maxIndex;
        }
    }

    private static void swap(int a[], int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }


    /**
     * 在构造堆后，数组中第一个元素即堆顶为最大值。将它和最后一个元素交换，即最大值放到了n位置，再通过堆化的方法，将后续n-1个元素构造成堆。重复过程直到堆中只剩下一个元素。
     * 只能排序从1开始的数组部分
     *
     * @param a
     */
    public static void sort(int[] a) {
        //1.构造大根堆
        buildHeap(a, a.length - 1);

        int k = a.length - 1;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    @Test
    public void test() {
        int[] a = new int[]{50, 7, 5, 19, 8, 4, 1, 20, 13, 16};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
