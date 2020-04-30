package com.example.leetcode.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: icecrea
 * @create: 2020-04-30
 **/
public class LeetCode043_MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        int[] res = new int[cs1.length + cs2.length];
        for (int i = cs1.length - 1; i >= 0; i--) {
            for (int j = cs2.length - 1; j >= 0; j--) {
                int mul = (cs1[i] - '0') * (cs2[j] - '0');
                int p1 = i + j, p2 = i + j + 1;

                //
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        System.out.println(Arrays.toString(res));
        int index = 0;
        while (index < res.length && res[index] == 0) {
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (; index < res.length; index++) {
            sb.append(res[index]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test() {
        System.out.println(multiply("2", "3"));
    }
}
