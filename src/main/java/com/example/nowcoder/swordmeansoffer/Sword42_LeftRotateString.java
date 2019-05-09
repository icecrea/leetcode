package com.example.nowcoder.swordmeansoffer;

/**
 * @description: 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author: icecrea
 * @create: 2019-05-09 23:59
 **/
public class Sword42_LeftRotateString {

    public String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) {
            return "";
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void reverse(char[] chars, int low, int high) {
        char temp;
        while (low < high) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }


    public String LeftRotateString2(String str, int n) {
        int len = str.length();
        if (len == 0) {
            return "";
        }
        n = n % len;
        str += str;
        return str.substring(n, n + len);
    }
}
