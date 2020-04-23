package com.example.leetcode.other;

/**
 * @description: 交换两数 亦或方法
 * @auther: icecrea
 * @date: 2020/4/23
 */
public class exchangeNumber {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        System.out.println("a和b交换前a=" + a + "\tb=" + b);
        a = a ^ b; // 此时a的值为a ^ b;
        b = a ^ b; // 此时b的值为a ^ b ^ b = a;
        a = a ^ b; // 此时a的值为a ^ b ^ a = b;
        System.out.println("a和b交换后a=" + a + "\tb=" + b);
    }

}
