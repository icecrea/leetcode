package com.example.topinterview.easy.string;

import org.junit.Test;

/**
 * @description: 实现strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @author: icecrea
 * @create: 2019-03-13 10:24
 **/
public class array38 {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int h = i;
            for (int j = 0; j < needle.length() && h < haystack.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(h)) {
                    break;
                }
                h++;
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * 更优雅的解法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                //比较字符串长度已经超过了原字符串长度
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

    @Test
    public void test() {
//        System.out.println(strStr("hello","ll"));
//        System.out.println(strStr("mississippi","issip"));
        System.out.println(strStr("mississippi", "issipi"));
    }
}
