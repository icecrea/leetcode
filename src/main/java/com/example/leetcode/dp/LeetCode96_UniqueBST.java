package com.example.leetcode.dp;

import org.junit.Test;

/**
 * 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class LeetCode96_UniqueBST {

    /**
     * 当 i=1 时，只有一个节点，f(1)=1f(1)=1.
     * 当 i=2 时，存在两个节点1, 2。当以2作为根节点是只有1种，以1作为根节点时也只有1种，因此总共有2种。
     * 当 i=3 时，存在三个节点1，2，3。我们来进行详细的叙述。
     * 以3根节点时。其它的节点1,2只能在左子树。此时就转换成了{1,2}有多少种二叉树
     * 以2为根节点时，节点3只能在右子树，节点1只能在左子树。
     * 以1为根节点时，节点{2,3}只能在右子树。此时就变成{2,3}有多少种二叉树
     * 因此有f(3) = 2 + 1 + 2 = 5种
     *
     * 对于以i为节点情况，左子树有i-1个节点，右子树有n-i个节点。i从1到n加和为最后结果
     * f(i) = f(0)*f(i-1) + f(1)*f(i-2) +...f(i-1)f(0)
     *
     *
     * dp(n) 长度为n的序列的bst数量
     * dp(n) = f(1, n) + f(2, n) + ... + f(n, n).
     * f(i, n) = dp(i-1) * dp(n-i) 如f(3,7) = dp(2) * dp(4)
     *
     * 得到递推公式
     * dp(n) = dp(0) * dp(n-1) + dp(1) * dp(n-2) + … + dp(n-1) * dp(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //0的话乘1等于本身
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
    }
}
