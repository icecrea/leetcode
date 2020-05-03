package com.example.leetcode.binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

/**
 * @description: 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @author: icecrea
 * @create: 2020-05-03
 **/
public class LeetCode112_PathSum {
    boolean flag = false;

    /**
     * 注意是到叶子节点的最小深度
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dfs(root, root.val, sum);
        return flag;
    }

    void dfs(TreeNode root, int cur, int sum) {
        if (root == null) {
            return;
        }
        if (cur == sum && root.left == null && root.right == null) {
            flag = true;
            return;
        }
        if (root.left != null) {
            dfs(root.left, cur + root.left.val, sum);
        }
        if (root.right != null) {
            dfs(root.right, cur + root.right.val, sum);
        }
    }
}
