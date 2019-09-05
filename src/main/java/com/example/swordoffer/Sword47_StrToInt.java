package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 字符串转整数
 * <p>
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * 复制
 * +2147483647
 * 1a33
 * 输出
 * 复制
 * 2147483647
 * 0
 * @author: icecrea
 * @create: 2019-09-05 00:33
 **/
public class Sword47_StrToInt {


    /**
     * int型溢出后为-2145481649，通过溢出前后比较
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 1;
        int start = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
            symbol = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = -1;
        }
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return 0;
            }

            int sum = result * 10 + (chars[i] - '0');

            if ((sum - (chars[i] - '0')) / 10 != result) {
                return 0;
            }

            result = result * 10 + (int) (chars[i] - '0');

        }
        // 注意，当value=-2147483648时，value=-value
        result = symbol * result;
        return result;
    }


    @Test
    public void test() {
        int i = new Sword47_StrToInt().StrToInt("2147483648");
        System.out.println(i);
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        max += 2000000;
        System.out.println(max);


    }
}
