package com.example.swordoffer;

/**
 * @description:斐波那契数列 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @author: icecrea
 * @create: 2019-04-17 23:54
 **/
public class Sword07_Fibonacci {

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public int Fibonacci2(int n) {
        if (n == 1) {
            return 1;
        }
        int p = 0;
        int q = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = p + q;
            p = q;
            q = ans;
        }
        return ans;
    }

}
