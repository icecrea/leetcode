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
        List<String> ans = new ArrayList<>();
        doRestore(0, new StringBuilder(), ans, s);
        return ans;
    }

    /**
     * @param k         IP 地址的第 k 段
     * @param tempAdd   IP 地址的第 k 段内容
     * @param addresses IP 地址结果集合
     * @param s         给定字符串的待处理部分
     */
    private void doRestore(int k, StringBuilder tempAdd, List<String> addresses, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAdd.toString());
            }
        } else {
            for (int i = 0; i < s.length() && i <= 2; i++) {
                if (i != 0 && s.charAt(0) == '0') {
                    // 某一段如果大于 1 位，不能以 0 作为开头
                    break;
                }
                String part = s.substring(0, i + 1);
                if (Integer.valueOf(part) <= 255) {
                    if (tempAdd.length() != 0) {
                        // 不是第一部分就在前面加个 "."
                        part = "." + part;
                    }
                    tempAdd.append(part);
                    doRestore(k + 1, tempAdd, addresses, s.substring(i + 1));
                    tempAdd.delete(tempAdd.length() - part.length(), tempAdd.length());
                }
            }
        }
    }
}
