package com.example.leetcode.binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

/**
 * @description: 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 * @author: icecrea
 * @create: 2020-01-10
 **/
public class LeetCode965_UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        return same(root, root.val);
    }

    public boolean same(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return root.val == val && same(root.left, val) && same(root.right, val);
    }
}
