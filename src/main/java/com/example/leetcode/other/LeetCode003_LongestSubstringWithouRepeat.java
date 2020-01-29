package com.example.leetcode.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @auther: icecrea
 * @date: 2020/1/22
 */
public class LeetCode003_LongestSubstringWithouRepeat {

    /**
     * 暴力法
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet();
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                boolean res = set.add(s.charAt(end));
                max = Math.max(max, set.size());
                if (!res) {
                    set.clear();
                    break;
                }
            }
        }
        return max;
    }

    /**
     * 滑动窗口解法
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }


    /**
     * 滑动窗口优化
     * 定义字符到索引的映射
     * 如果 s[j]s[j] 在 [i,j) 范围内有与 j重复的字符，我们不需要逐渐增加 i。
     * 我们可以直接跳过 [i，j']，并将i变成j'+1
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap();
        int max = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


}
