package com.example.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * @author: icecrea
 * @create: 2019-03-27 10:21
 **/
public class LeetCode179_LargestNumber {

    public String largestNumber(int[] num) {

        if (num == null || num.length == 0) {
            return "";
        }

        String[] numStr = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            numStr[i] = String.valueOf(num[i]);
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(numStr, comp);
        if (numStr[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : numStr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
