package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 字符串转整数
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 * @author: icecrea
 * @create: 2019-09-05 00:33
 **/
public class Sword49_StrToInt {


    /**
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        // start用来区分第一位是否为符号位
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
        long result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return 0;
            }
            //位运算 =  n*10 + a[i]
//            result = (result << 1) + (result << 3) + (chars[i] & 0xf);
            result = result * 10 + (chars[i] - '0');
            if (symbol == 1 && result > Integer.MAX_VALUE) {
                return 0;
            }
            if (symbol == -1 && (-1) * result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        // 注意，当value=-2147483648时，value=-value
        result = symbol * result;
        return (int) result;
    }


    @Test
    public void test() {
        System.out.println(new Sword49_StrToInt().StrToInt("2147483648"));
        System.out.println(new Sword49_StrToInt().StrToInt("2147483647"));
        System.out.println(new Sword49_StrToInt().StrToInt("-2147483648"));
        System.out.println(new Sword49_StrToInt().StrToInt("-2147483647"));
        System.out.println(new Sword49_StrToInt().StrToInt("-2147483649"));
        System.out.println(new Sword49_StrToInt().StrToInt("1234"));


        int max = Integer.MAX_VALUE;
        System.out.println("MAX :" + Integer.MAX_VALUE);
        max += 2000000;
        System.out.println("MAX+ :" + max);


        int min = Integer.MIN_VALUE;
        System.out.println("MIN :" + Integer.MIN_VALUE);
        min -= 2000000;
        System.out.println("MIN- :" + min);


        int res = 4;
        // 乘8 + 乘2 = 乘10
        res = (res << 1) + (res << 3);
        System.out.println(res);

        // ascii码8位，字符‘0’-‘9’后四位二进制ascii码，对应其字符代表的数字
        System.out.println('8' & 0xf);
        System.out.println('3' & 0xf);
        System.out.println('0' & 0xf);
    }
}
