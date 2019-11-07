package com.example.swordoffer;

/**
 * @description: 字符流中第一个不重复的数字、
 * <p>
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author: icecrea
 * @create: 2019-09-11 12:57
 **/
public class Sword54_FirstAppearingOnce {

    /**
     * 一个字符8位，使用256数组足够
     */
    int[] hashtable = new int[256];
    StringBuffer s = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch) {
        s.append(ch);
        if (hashtable[ch] == 0) {
            hashtable[ch] = 1;
        } else {
            hashtable[ch] += 1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] str = s.toString().toCharArray();
        for (char c : str) {
            if (hashtable[c] == 1) {
                return c;
            }
        }
        return '#';
    }

}
