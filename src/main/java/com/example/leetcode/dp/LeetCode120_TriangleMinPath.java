package com.example.leetcode.dp;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class LeetCode120_Triangle {
    /**
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     *
     * 自顶向下和自底向上的最短路径是相同的
     * 如果从顶向下，需要考虑很多判空条件，所以自底向上计算
     * 转移方程如下
     * num[i][j] = min(num[i+1][j]，num[i+1][j+1]) + num[i][j]
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        List<Integer> res = new ArrayList<>(triangle.get(row - 1));
        for (int i = row - 2; i >= 0; i--) {
            List<Integer> rowList = triangle.get(i);
            for (int j = 0; j < rowList.size(); j++) {
                res.set(j, Math.min(res.get(j), res.get(j + 1)) + rowList.get(j));
            }
        }
        return res.get(0);
    }

    @Test
    public void test() {
        List<List<Integer>> list = new ArrayList();
        list.add(Lists.newArrayList(2));
        list.add(Lists.newArrayList(3, 4));
        list.add(Lists.newArrayList(6, 5, 7));
        list.add(Lists.newArrayList(4, 1, 8, 3));
        int i = minimumTotal(list);
        System.out.println(i);

    }

}
