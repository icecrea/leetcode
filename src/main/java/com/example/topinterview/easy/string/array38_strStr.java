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
public class array38_strStr {
    /**
     * 朴素的遍历算法
     * @param haystack
     * @param needle
     * @return
     */
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

    /**
     * kmp算法
     * 部分匹配表(Partial Match Table)的数组
     * next 数组是一个部分匹配表  "部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度。以"ABCDABD"为例
     * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrKmp(String haystack, String needle) {

        int[] next = getNext(needle);

        int i = 0;
        int j = 0;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || h[i] == n[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j == needle.length()){
            return i - j;
        }
        return -1;
    }

    /**
     * 以模式字符串为主字符串（下标i），以模式字符串的前缀为目标字符串（下标j）
     * 可以用"abababca" debug理解
     * 看图理解 ： https://www.zhihu.com/question/21923021
     *
     * @param ps
     */
    public int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[ps.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        // 第一格设置-1 所以外圈遍历次数为n-1
        while (i < p.length - 1) {
            //i 是永远不会倒退的，如果i和j匹配，都后移继续匹配
            if (j == -1 || p[i] == p[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                //从上一次匹配到的相同地方再往后匹配，防止遗漏
                //每次J向前回溯，直到回溯到前缀串的头，即j== -1，再继续遍历逻辑
                j = next[j];
            }
        }
        return next;
    }


    @Test
    public void test() {
        System.out.println(strStr("hello","ll"));
//        System.out.println(strStr("mississippi","issip"));
//        System.out.println(strStr("mississippi", "issipi"));
//        getNext("aba", new int[3]);
        System.out.println(strStrKmp("hello","ll"));
    }

}
