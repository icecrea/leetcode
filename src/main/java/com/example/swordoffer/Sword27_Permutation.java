package com.example.swordoffer;

import java.util.*;

/**
 * @description: 字符串全排列
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @author: icecrea
 * @create: 2019-04-22 13:58
 **/
public class Sword27_Permutation {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        HashSet<String> set = new HashSet();
        dfs(str.toCharArray(), 0, set);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    public void dfs(char[] cs, int i, HashSet<String> set) {
        if (i == cs.length - 1) {
            set.add(String.valueOf(cs));
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                dfs(cs, i + 1, set);
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 输入一组不重复的数字，求全排列
     * 参考： https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban
     * @param nums
     * @return
     */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * def backtrack(...):
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(...)
     *         撤销选择
     * @param nums
     * @param track
     */
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择 （非最优解）
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        Sword27_Permutation p = new Sword27_Permutation();
        System.out.println(p.Permutation("abc").toString());
        System.out.println(p.Permutation("abb").toString());
    }
}
