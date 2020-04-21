package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 电话号码的字母组合
 * @auther: icecrea
 * @date: 2020/3/10
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode017_LetterCombinationsPhoneNumber {


    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        backTrack(res, digits, 0, "");
        return res;
    }

    public void backTrack(List<String> res, String digits, int index, String track) {
        if (index == digits.length()) {
            res.add(track);
            return;
        }
        //先找到数字，再找到对应的可选择范围
        String letters = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
//            track += letters.charAt(i);
//            backTrack(res, digits, index + 1, track);
//            track = track.substring(0, track.length() - 1);

//             等同下面
            backTrack(res, digits, index + 1, track + letters.charAt(i));
        }
    }

    @Test
    public void test() {
//        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations2("23"));
    }


}
