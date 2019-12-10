package com.example.topinterview.easy.string;

import org.junit.Test;

/**
 * @description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * @author: icecrea
 * @create: 2019-03-13 19:59
 **/
public class array40_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //注意是相同的公共前缀. 必须均为前缀，所以判断重合位置是否为0，并逐渐缩减pre长度
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.isEmpty()) {
                    return "";
                }
            }
        }
        return pre;
    }

    /**
     * 优化： 竖向扫描法
     * 从前往后，比较每个字符串每列的值，如果不相同，则最长公共前缀判定结束
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            //第一行i列字符
            char c = strs[0].charAt(i);
            //依次比较剩余行相同字符
            for (int j = 1; j < strs.length; j++) {
                // 若j行i列的字符与第一行i列的字符不同，代表最长公共前缀判定结束
                // 若第一行新i列已经超出了剩余行的最大列出，也代表最长公共前缀判定结束
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /**
     * Divide and conquer
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {

            }
            return left.substring(0, i);
        }
        return left.substring(0, min);
    }


    @Test
    public void test() {
        String[] s = new String[]{"leets", "leetcode", "leet", "leeds"};
        System.out.println(longestCommonPrefix(s));
    }
}
