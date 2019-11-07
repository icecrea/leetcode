package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

/**
 * @description: 平衡二叉树 TODO 非递归
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author: icecrea
 * @create: 2019-05-09 08:54
 **/
public class Sword39_IsBalancedTree {
    /**
     * 左右子树的高度差绝对值不超过1
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
