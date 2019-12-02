package com.example.leetcode.dp;

import org.junit.Test;

/**
 * 四键键盘
 * Imagine you have a special keyboard with the following keys:
 *
 * Key 1: (A): Prints one 'A' on screen.
 * Key 2: (Ctrl-A): Select the whole screen.
 * Key 3: (Ctrl-C): Copy selection to buffer.
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 *
 * Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.
 *
 * Example 1:
 *
 * Input: N = 3
 * Output: 3
 * Explanation:
 * We can at most get 3 A's on screen by pressing following key sequence:
 * A, A, A
 * Example 2:
 *
 * Input: N = 7
 * Output: 9
 * Explanation:
 * We can at most get 9 A's on screen by pressing following key sequence:
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 * Note:
 *
 * 1 <= N <= 50
 * Answers will be in the range of 32-bit signed integer.
 */
public class LeetCode651_4KeysKeyboard {

    public int maxA(int n) {
        return dp(n, 0, 0);
    }

    /**
     * 递归方法
     * 缺点：1.有重复问题 2.有可能出现这样的操作序列 C-A C-C，C-A C-C... 或者 C-V,C-V,... 必然不是最优，无谓的子问题计算
     *
     * @param keyTimes 剩下按键次数
     * @param curSize  屏幕当前存在的数量
     * @param copy     在粘贴板的数量
     * @return
     */
    public int dp(int keyTimes, int curSize, int copy) {
        if (keyTimes <= 0) {
            return curSize;
        }
        return Math.max(
                Math.max(dp(keyTimes - 1, curSize + 1, copy), //print A
                        dp(keyTimes - 1, curSize + copy, copy)), //c-v
                dp(keyTimes - 2, curSize, curSize)); //c-a c-c 需要连着一起使用
    }

    /**
     * 优化状态方程
     * 最优按键序列一定只有两种情况：
     * 要么一直按 A：A,A,...A（当 N 比较小时）。
     * 要么是这么一个形式：A,A,...C-A,C-C,C-V,C-V,...C-V（当 N 比较大时）
     *
     * dp[i] = max( 这次按 A 键，这次按 C-V )
     *
     * 最后一个按键要么是A 要么是C-V
     * 用一个变量 j 作为若干 C-V 的起点，则dp[j-2]代表了A的数量
     */
    public int maxA2(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // 按 A 键
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }


    @Test
    public void test() {

        System.out.println(maxA(3));
        System.out.println(maxA(7));
        System.out.println(maxA2(3));
        System.out.println(maxA2(7));

    }

}
