package com.example.nowcoder.swordmeansoffer;

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


}
