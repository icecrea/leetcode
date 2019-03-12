package com.example.topinterview.easy.string;

/**
 * @description: 字符串中第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * @author: icecrea
 * @create: 2019-03-12 12:48
 **/
public class array34 {

    /**
     * 小写字母 可以用26整形数组存出现次数，下标通过char类型相减变成整数，对应从a到z
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法1转成字符数组 省去了 charAt length 等方法耗时
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
