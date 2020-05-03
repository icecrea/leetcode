package com.example.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 复原ip地址 TODO
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/21
 */
public class LeetCode093_RestoreIpAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        // 回溯
        backTrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    // 中间两个参数解释：pos-当前遍历到 s 字符串中的位置，cur-当前存放已经确定好的 ip 段的数量
    private void backTrack(String s, int pos, List<String> cur, List<String> res) {
        if (cur.size() == 4) {
            if (pos == s.length()) {
                res.add(String.join(".", cur));
            }
            return;
        }

        // ip 地址每段最多有三个数字
        for (int i = 1; i <= 3; i++) {
            // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可。
            if (pos + i > s.length()) {
                break;
            }

            String segment = s.substring(pos, pos + i);
            // 剪枝条件：段的起始位置不能为 0，段拆箱成 int 类型的长度不能大于 255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            cur.add(segment);
            backTrack(s, pos + i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }



}
