package com.example.leetcode.sort;

import java.util.Collections;
import java.util.List;

/**
 * @description: 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 * 说明:
 * <p>
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 * @author: icecrea
 * @create: 2019-03-28 23:53
 **/
public class LeetCode524_LongestWordInDictionaryThroughDeleting {

    /**
     * 先对列表排序 然后依次判断
     *
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            // abpcplea  c      a p p l a
            // apple  dictWord  a p p l a
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            }
            if (i == dictWord.length()) {
                return dictWord;
            }
        }
        return "";
    }

    /**
     * 不排序方式
     *
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord2(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            }
            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
                    longest = dictWord;
                }
            }
        }
        return longest;
    }


    public String findLongestWord3(String s, List<String> d) {
        String ans = "";

        for (String word : d) {
            if (check(s, word)) {
                if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    private boolean check(String s, String target) {
        int start = -1;
        for (int i = 0; i < target.length(); i++) {
            int index = s.indexOf(target.charAt(i), start + 1);
            if (index == -1) {
                return false;
            }
            start = index;
        }
        return true;
    }
}
