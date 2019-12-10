package com.example.topinterview.easy.other;

/**
 * @description: 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * @author: icecrea
 * @create: 2019-03-22 15:53
 **/
public class array69_missingNumber {
    /**
     * 1到n的和 - 数组和
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        return n * (n + 1) / 2 - sum;
    }
}
