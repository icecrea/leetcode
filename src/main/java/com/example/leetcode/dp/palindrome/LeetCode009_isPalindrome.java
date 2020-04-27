package com.example.leetcode.dp.palindrome;

import org.junit.Test;

/**
 * @description: 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * @auther: icecrea
 * @date: 2019/12/16
 */
public class LeetCode009_isPalindrome {
    /**
     * 特别注意：需要用字符串的equals，两边都需要转成字符串格式
     */
    public boolean isPalindrome(int x) {
        String s = new StringBuilder(x + "").reverse().toString();
        return (x + "").equals(s);
    }

    /**
     * 取后半部分数字进行反转
     * 注意：回文数的位数可奇可偶，所以当它的长度是偶数时，它对折过来应该是相等的；当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数（除以 10 并取整）。
     * 具体做法如下：
     * 1.每次进行取余操作 （ %10），取出最低的数字：y = x % 10
     * 2.将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
     * 3.每取一个最低位数字，x 都要自除以 10
     * 4.判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
     * 5.最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertN = 0;
        while (x > revertN) {
            revertN = revertN * 10 + x % 10;
            x /= 10;
        }
        return x == revertN || x == revertN / 10;
    }


    @Test
    public void test() {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
    }
}
