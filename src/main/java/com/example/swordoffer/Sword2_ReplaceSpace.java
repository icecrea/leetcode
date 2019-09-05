package com.example.swordoffer;

/**
 * @description: 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * @author: icecrea
 * @create: 2019-04-17 11:34
 **/
public class Sword2_ReplaceSpace {


    /**
     * 从后往前替换，减少移动次数
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int spacenum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spacenum++;
            }
        }
        int indexold = str.length() - 1;
        int newlength = str.length() + spacenum * 2;
        int indexnew = newlength - 1;
        str.setLength(newlength);
        for (; indexold >= 0 ; --indexold) {
            if (str.charAt(indexold) == ' ') {
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            } else {
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }
}
