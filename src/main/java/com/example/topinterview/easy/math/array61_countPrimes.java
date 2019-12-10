package com.example.topinterview.easy.math;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @author: icecrea
 * @create: 2019-03-19 10:42
 **/
public class array61_countPrimes {
    /**
     * 从 2 开始，2 是一个素数，那么 2 × 2 = 4, 3 × 2 = 6, 4 × 2 = 8... 不可能是素数。
     * 3 也是素数，那么 3 × 2 = 6, 3 × 3 = 9, 3 × 4 = 12... 不可能是素数。
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        //对于i 判断素数 只需要遍历到sqrt(i)即可
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++)
            if (isPrime[i]) {
                count++;
            }
        return count;
    }

    @Test
    public void test() {
        System.out.println(countPrimes(10));
    }

}
