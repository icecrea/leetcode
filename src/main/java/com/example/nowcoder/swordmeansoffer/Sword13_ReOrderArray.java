package com.example.nowcoder.swordmeansoffer;

/**
 * @description:调整数组顺序使奇数位于偶数前面 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: icecrea
 * @create: 2019-04-18 13:00
 **/
public class Sword13_ReOrderArray {

    /**
     * 用例:
     * [1,2,3,4,5,6,7]
     * <p>
     * 对应输出应该为:
     * <p>
     * [1,3,5,7,2,4,6]
     * <p>
     * 你的输出为:
     * <p>
     * [1,3,5,7,2,6,4]
     * <p>
     * 1354267
     * 1356264
     * <p>
     * 1234567
     * 1334567
     * 1354567
     *
     * @param a
     */
    public void reOrderArray(int[] a) {
        int i = 0;
        while (i <= a.length - 1) {
            if ((a[i] & 1) == 0) {
                for (int j = i + 1; j <= a.length - 1; j++) {
                    if ((a[j] & 1) == 1) {
                        swap(a, i, j);
                        break;
                    }
                }
            }
            i++;
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public void reOrderArray2(int[] a) {
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
