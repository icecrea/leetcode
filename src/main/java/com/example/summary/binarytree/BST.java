package com.example.summary.binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

/**
 * @description: 二叉搜索树专题
 * @auther: icecrea
 * @date: 2020/4/24
 */
public class BST {

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
