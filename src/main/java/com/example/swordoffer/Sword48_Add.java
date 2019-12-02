package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 不用加减乘除做加法
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author: icecrea
 * @create: 2019-11-07
 **/
public class Sword48_Add {
    /**
     * 1.两个数异或：相当于每一位相加，而不考虑进位；
     * 2.两个数相与，并左移一位：相当于求得进位；
     * 3.将上述两步的结果相加
     */
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            //求和
            int sum = num1 ^ num2;
            //求进位
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }

    @Test
    public void test() {
        int a = 5;
        int b = 7;
        System.out.println(Add(a, b));
        //circle0: num1 5 num2 7   | 101 111
        //circle1: sum 2 carry 10  | 010 1010
        //circle2: sum 8 carry 4   | 1000 100
        //circle3: sum 12 carry 0  | 1100 0
    }
}
