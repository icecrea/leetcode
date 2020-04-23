package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 数组中的逆序对 TODO
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 * 如在数组7, 5, 6, 4 中， 一共存在5个逆序对，分别是（7, 6）、（7，5），(7, 4）、（6, 4）和（5, 4）
 * @author: icecrea
 * @create: 2019-05-08 20:54
 **/
public class Sword35_InversePairs {


    int res = 0;

    /**
     * 归并排序的思路
     *
     * @param array
     * @return
     */
    public int InversePairs(int[] array) {
        if (array != null) {
            mergeSort(array, 0, array.length - 1);
        }
        return res;
    }


    void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    /**
     * 7 5 6 4
     * 57 46 res = 2
     * 5>4 res =3
     * 7>4 7>6 res=5
     */
    void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else if (a[i] > a[j]) {
                tmp[k++] = a[j++];
                res += mid - i + 1;// 核心代码，和归并唯一的不同
//                res %= 1000000007;//题目要求取余
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[start + i] = tmp[i];
        }
    }

    @Test
    public void test() {
        System.out.println(InversePairs(new int[]{7, 5, 6, 4}));
    }
}
