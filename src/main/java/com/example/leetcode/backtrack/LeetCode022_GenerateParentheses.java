package com.example.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/2/21
 */
public class LeetCode022_GenerateParentheses {
    /**
     * 回溯模板
     * def backtrack(...):
     * for 选择 in 选择列表:
     * 做选择
     * backtrack(...)
     * 撤销选择
     *
     * n个左括号，n个右括号的组合
     * @param n
     * @return
     */
    List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();
        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();
        // 可用的左括号和右括号数量初始化为 n
        backtrack(0, 0, track, res, n);
        return res;
    }

    void backtrack(int left, int right, StringBuilder track, List<String> res, int n) {
        // 左括号数量应该大于右括号
        if (right > left) {
            return;
        }
        if (left > n || right > n) {
            return;
        }
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == n && right == n) {
            res.add(track.toString());
            return;
        }

        // 尝试放一个左括号
        track.append('(');
        backtrack(left + 1, right, track, res, n);
        track.deleteCharAt(track.length() - 1);

        // 尝试放一个右括号
        track.append(')');
        backtrack(left, right + 1, track, res, n);
        track.deleteCharAt(track.length() - 1);
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(4));
    }

}
