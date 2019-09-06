package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 构建乘积数组
 * 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author: icecrea
 * @create: 2019-09-06 00:52
 **/
public class Sword49_Multiply {

    /**
     * TODO
     * 构造左右数组分别存到当前的从左往右/从右往左乘积
     *
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int left[] = new int[A.length];
        int right[] = new int[A.length];
        left[0] = A[0];
        right[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] * A[i];
        }

        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i];
        }
        int res[] = new int[A.length];

        res[0] = right[1];
        res[res.length - 1] = left[res.length - 2];

        for (int i = 1; i < res.length - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }


    /**
     * 剑指offer解法
     * 结合画图， 构造上三角和下三角，每一行的乘积值为B[i]，左上到右下对角线的值均为1，每行从左往右为a[0]-a[n-1], 最后返回B
     * 通过计算三角的乘积最终求值
     *
     * @param A
     * @return
     */
    public int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //计算上三角 (因此此时下三角已经计算入b[i]了，所以不能再用B累乘，从后往前累乘A[j+1]赋值即可)
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

    @Test
    public void test() {
        int[] a = new int[]{1, 4, 2, 3};
        int[] multiply = multiply(a);
        for (int i : multiply) {
            System.out.println(i);
        }

    }

}
