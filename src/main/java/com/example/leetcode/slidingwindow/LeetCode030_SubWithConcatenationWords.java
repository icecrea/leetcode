package com.example.leetcode.slidingwindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 串联所有单词子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *  
 * 示例 1：
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * @auther: icecrea
 * @date: 2020/1/29
 */
public class LeetCode030_SubWithConcatenationWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0) {
            return  new ArrayList();
        }
        List<Integer> res = new ArrayList<>();
        int size = words[0].length();
        Map<String, Integer> need = new HashMap();
        for (String w : words) {
            need.merge(w, 1, (o, n) -> o + 1);
        }

        for (int i = 0; i < size; i++) {
            Map<String, Integer> window = new HashMap();
            int left = i, right = i, valid = 0;
            while (right <= s.length() - size) {
                String rStr = s.substring(right, right + size);
                right = right + size;
                if (need.containsKey(rStr)) {
                    window.merge(rStr, 1, (o, n) -> o + 1);
                    if (window.get(rStr).equals(need.get(rStr))) {
                        valid++;
                    }
                }

                while (right - left >= words.length * size) {
                    if (valid == need.size()) {
                        res.add(left);
                    }
                    String lStr = s.substring(left, left + size);
                    left = left + size;
                    if (need.containsKey(lStr)) {
                        if (window.get(lStr).equals(need.get(lStr))) {
                            valid--;
                        }
                        window.put(lStr, window.get(lStr) - 1);
                    }
                }
            }
        }

        return res;
    }

    @Test
    public void test() {

//        System.out.println("1234".substring(0, 4));
        System.out.println(findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));

        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"})); //预期[13]
    }
}
