package com.example.leetcode.other;

import com.example.swordoffer.Sword12_Power;
import org.junit.Test;

/**
 * @description: Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: icecrea
 * @create: 2020-05-03
 **/
public class LeetCode050_Powx {

    /**
     * @see Sword12_Power
     * 11的二进制是1011
     * 11 = 2³×1 + 2²×0 + 2¹×1 + 2º×1 = 2³+2¹+2º
     * a¹¹= a^2³ * a ^2¹ * a^2º
     */
    public double myPow(double x, int n) {
        int sign = n;
        double res = 1;
        n = Math.abs(n);
        while (n != 0) {
            if ((n & 1) == 1) {//和1与取末尾
                res *= x;
            }
            x *= x;
            n = n >>> 1;//注意此处>>>
        }
        return sign >= 0 ? res : 1 / res;
    }

    @Test
    public void test() {
        System.out.println(myPow(2.0, -2));
        System.out.println(Math.abs(-2147483648));
        System.out.println(myPow(1.0, -2147483648));

    }

}
