package com.example.nowcoder.swordmeansoffer;

import org.junit.Test;

/**
 * @description:调整数组顺序使奇数位于偶数前面 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: icecrea
 * @create: 2019-04-18 13:00
 **/
public class Sword13_ReOrderArray {


    /**
     * 找到第一个偶数 和其后的第一个奇数
     * 中间数字整体后移一位， 奇数放到偶数位置
     * <p>
     * 358761
     * 735861
     * 173586
     *
     * @param a
     */
    public void reOrderArray(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int i = 0, j;
        while (i < a.length) {
            while (i < a.length && (a[i] & 1) == 1) {
                i++;
            }
            j = i + 1;
            while (j < a.length && (a[i] & 0) == 0) {
                j++;
            }
            if (j < a.length) {
                int tmp = a[j];
                //全部后移一位
                for (int p = j - 1; p >= i; p--) {
                    a[p + 1] = a[p];
                }
                a[i++] = tmp;
            } else {
                break;
            }
        }
    }


    public void reOrderArray2(int [] array) {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        int k = 0;//记录已经摆好位置的奇数的个数
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > k) {//j >= k+1
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }

    @Test
    public void test() {
        int a[] = new int[]{3, 5, 8, 7, 6, 1};
        reOrderArray2(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
