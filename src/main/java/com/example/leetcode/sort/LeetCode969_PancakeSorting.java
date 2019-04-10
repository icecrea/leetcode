package com.example.leetcode.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 煎饼排序
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
 * 我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 * <p>
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 A = [3, 2, 4, 1]
 * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
 * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
 * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
 * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如[3，3]，也将被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * A[i] 是 [1, 2, ..., A.length] 的排列
 * @author: icecrea
 * @create: 2019-04-02 11:12
 **/
public class LeetCode969_PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        // 每次反转 确定最后一个数字是正确的
        for (int x = A.length; x > 0; --x) {
            int i = 0;
            // 注意没有相同的 可能超上限情况
            while (A[i] != x && i < x - 1) {
                i++;
            }
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    /**
     * 反转前k个数字
     *
     * @param A
     * @param k
     */
    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }


    @Test
    public void test() {
        int[] a = new int[]{3, 2, 4, 1};
        System.out.println(pancakeSort(a));
        /**
         * 3 2 4 1
         *
         * 4 2 3 1  3
         * 1 3 2 4  4
         *
         * 3 1 2 4  2
         * 2 1 3 4  3
         *
         * 2 1 3 4  1
         * 1 2 3 4  2
         *
         * 1 2 3 4  1
         * 1 2 3 4  1
         */

//        int[] a= new int[]{1, 4, 3, 3};
//        System.out.println(pancakeSort(a));
        for (int z : a) {
            System.out.println(z);
        }
    }


}
