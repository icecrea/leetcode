package com.example.leetcode.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 字符串s1包含字符串s2的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/23
 */
public class LeetCode567_PermutationInString {

    boolean minWindow(String t, String s) {
        Map<Character, Integer> need = new HashMap();
        Map<Character, Integer> window = new HashMap();
        for (char c : t.toCharArray()) {
            need.merge(c, 1, (o, n) -> o + 1);
        }

        int left = 0, right = 0; // 注意这里的left,right 计算的时候实际上是左闭右开区间 [left,right)
        int valid = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.merge(c, 1, (o, n) -> o + 1);
                if (window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩 排列长度需要一致
            while (right - left >= t.length()) {
                // 在这里更新最小覆盖子串
                if (valid == need.size()) {
                    return true;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).intValue() == need.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return false;
    }

    @Test
    public void test() {
        System.out.println(minWindow("ab", "eidbaooo"));
        System.out.println(minWindow("ab", "eidboaoo"));
    }
}
