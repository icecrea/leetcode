package com.example.swordoffer;

/**
 * @description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author: icecrea
 * @create: 2019-04-18 09:03
 **/
public class Sword12_Power {
    public double Power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }


    /**
     * 2^11 = 2^1 * 2^2 * 2^8
     * 2^1011 = 2^0001 * 2^0010 * 2^1000
     * <p>
     * 写出指数的二进制表达，例如13表达为二进制1101。
     * 举例:10^1101 = 10^0001* 10^0100 * 10^1000。
     * 通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public double Power2(double base, int n) {
        double res = 1;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            exponent = -n;
        } else {
            // 0次方
            return 1;
        }

        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                res *= base;
            }
            // 翻倍
            base *= base;
            // 右移一位
            exponent >>= 1;
        }
        return n >= 0 ? res : (1 / res);
    }

}
