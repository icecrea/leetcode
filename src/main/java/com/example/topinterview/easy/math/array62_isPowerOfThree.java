package com.example.topinterview.easy.math;

/**
 * @description: 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 27
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: true
 * 示例 4:
 * <p>
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * @author: icecrea
 * @create: 2019-03-19 12:07
 **/
public class array62_isPowerOfThree {
    /**
     * 超时
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        int z = 3;
        while (z <= n) {
            if (z == n) {
                return true;
            }
            z = z * 3;
        }
        return false;
    }

    public boolean isPowerOfThree2(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return n > 0 && (1162261467 % n == 0);
    }

    /**
     * @param n
     * @return
     */
    public boolean isPowerOfThree3(int n) {
        return (n > 0) && (Math.log10(n) / Math.log10(3) % 1 == 0);
    }
}
