package com.example.swordoffer;

/**
 * @description: 正则表达式匹配
 * <p>
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * <p>
 * 下一个字符为*：
 * A.当前匹配：
 * 1.match(str,i + 1,pattern,j)  字符后移1位，模式不变，因为*可以匹配多位
 * 2.match(str,i,pattern,j + 2)  字符串不变，模式后移2位，相当于a*被忽略，代表出现零次的情况，如aaa 和 aa*aa*a
 * 3.match(str,i + 1,pattern,j + 2)  视为模式匹配一个字符，如aba 和 ab*a
 * B.当前不匹配：
 * 1.match(str,i,pattern,j + 2)  字符串不变，模式后移2位 相当于a*被忽略，代表出现零次的情况，如aaa 和 ab*ac*a
 *
 *
 * 下一个字符不为*：
 * A.当前匹配：
 * 1.match(str,i + 1,pattern,j + 1) 均后移
 * @author: icecrea
 * @create: 2019-09-06 09:20
 **/
public class Sword50_Match {


    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }


    /**
     * 讨论2种：先看 * 再看 匹配
     * 前提：当pattern遍历完，return取决于str是否遍历完，str恰好遍历完才返回true，再接下来讨论
     * 1.若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况
     * 一：当前匹配
     * 1.1match(str,i + 1,pattern,j)//跳过str  aaa a*
     * 1.2match(str,i,pattern,j + 2)//跳过pattern  aaa ab*ac*a
     * 1.3match(str,i + 1,pattern,j + 2)//这一种可以省略，相当于 1.1 + 1.2
     * 二：当前不匹配
     * match(str,i,pattern,j + 2)//跳过pattern  bc|d*bc
     * 2.下一个不是 *
     * 当前匹配 return match(str,i + 1,pattern,j + 1) ab|ab , aaa|a.a
     */
    private static boolean match(char[] str, int i, char[] pattern, int j) {
        //pattern遍历完了
        if (j == pattern.length) {
            //如果str也完了，返回true，不然false
            return str.length == i;
        }
        //注意数组越界问题，一下情况都保证数组不越界
        //下一个是*
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            //当前匹配
            if (str.length != i &&
                    (str[i] == pattern[j] || pattern[j] == '.')) {
                return match(str, i, pattern, j + 2)
                        || match(str, i + 1, pattern, j)
                        || match(str, i + 1, pattern, j + 2);
            } else {
                //当前不匹配
                return match(str, i, pattern, j + 2);
            }
        }
        //下一个不是“*”，当前匹配  如：ab|ab , aaa|a.a
        if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, i + 1, pattern, j + 1);
        }
        return false;
    }
}
