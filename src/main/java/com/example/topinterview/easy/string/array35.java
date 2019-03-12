package com.example.topinterview.easy.string;

/**
 * @description: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @author: icecrea
 * @create: 2019-03-12 12:55
 **/
public class array35 {
    /**
     * 很像上一题唯一字符，都是小写字母，且需要条件为字母出现次数，用int[26]数组来解决
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] cs = new int[26];
        for(int i=0;i<s.length();i++){
            cs[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++){
            cs[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<cs.length;i++){
            if(cs[i]!=0){
                return false;
            }
        }
        return true;
    }
}
