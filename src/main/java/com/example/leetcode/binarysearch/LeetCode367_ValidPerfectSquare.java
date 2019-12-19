package com.example.leetcode.binarysearch;

import org.junit.Test;

/**
 * @description: 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 示例 1：
 * 输入：16
 * 输出：True
 * 示例 2：
 * 输入：14
 * 输出：False
 * @auther: icecrea
 * @date: 2019/12/19
 */
public class LeetCode367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num, mid;
        while (left < right) {
            mid = (left + right) >>> 1;
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left * left) == num ? true : false;
    }

    @Test
    public void test() {
        int a = 111111111;
        int b = 111111111;
        double c = a * b;
        System.out.println((double) a * b);
        System.out.println((double) c);
        System.out.println(isPerfectSquare(2147483647));
        System.out.println(isPerfectSquare(2147483647));
    }
}
