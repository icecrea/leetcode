package com.example.topinterview.easy.string;

/**
 * @description: 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author: icecrea
 * @create: 2019-03-11 19:26
 **/
public class array33 {

    /**
     * 使用long 偏取巧
     * 循环
     * 每次取最后一位数字*10 （从0开始）+ 原数字删除最后一位数字
     * new : 3, 32 , 321
     * old : 32, 2 , 0
     * @param x
     * @return
     */
    public int reverse1(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            ans = 0;
        }
        return (int) ans;
    }

    /**
     * 大神解法 : 如果溢出，则新值和旧值是不同的
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
