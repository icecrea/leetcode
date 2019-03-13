package com.example.topinterview.easy.string;

/**
 * @description: 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * <p>
 * <p>
 * (理解题意 ： 是对之前的数进行计数，看之前的数中有几个对应的独立数字。
 * 比如说上一个数字为 2345 ，也就是“一个2一个3一个4一个5”则应该报数为 12131415；
 * 又比如说是 2233445 则是“两个2两个3两个4一个5”，报数结果为 22232415
 * 按照这种规律每次对前一个数字进行解读，报出下一个数字)
 * @author: icecrea
 * @create: 2019-03-13 13:07
 **/
public class array39 {
    public String countAndSay(int n) {
        String s = "1";
        int k;
        for (int i = 1; i < n; i++) {
            StringBuilder t = new StringBuilder();
            for (int j = 0; j < s.length(); j = k) {
                k = j;
                //找有几个相同的.
                while(k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }
                t.append(k - j).append(s.charAt(j));
            }
            s = t.toString();
        }
        return s;
    }


}
