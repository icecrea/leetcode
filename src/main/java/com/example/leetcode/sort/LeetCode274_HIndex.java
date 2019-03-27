package com.example.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: H指数
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * <p>
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: citations = [3,0,6,1,5]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 * <p>
 * <p>
 * <p>
 * 说明: 如果 h 有多种可能的值，h 指数是其中最大的那个
 * @author: icecrea
 * @create: 2019-03-27 20:27
 **/
public class LeetCode274_HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int refCount = 0;
        int len = citations.length;
        int res = 0;
        for (int i = len -1; i >= 0; i--) {
            if (citations[i] >= ++refCount) {
                res = refCount;
            }else {
                break;
            }
        }
        return res;
    }

    public int hIndex2(int[] citations) {
        int[] count = new int[citations.length+1];
        for (int c : citations) {
            if (c >= citations.length) {
                count[citations.length]++;
            } else {
                count[c]++;
            }
        }

        for (int i = citations.length; i>0; i--) {
            if (count[i] >= i) {
                return i;
            } else {
                count[i-1] += count[i];
            }
        }
        return 0;
    }

    @Test
    public void test(){
        // 0 1 3 5 6
        // 5 4 3 2 1
        System.out.println(hIndex(new int[]{3,0,6,1,5}));

        //  0 1
        //  2 1
        System.out.println(hIndex(new int[]{0,1}));

        // 0 0
        // 2 1
        System.out.println(hIndex(new int[]{0,0}));

        // 1 2
        // 2 1
        System.out.println(hIndex(new int[]{1,2}));

        // 1 3 4
        // 3 2 1
        System.out.println(hIndex(new int[]{1,3,4}));

    }
}
