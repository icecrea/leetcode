package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

/**
 * @description: 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @author: icecrea
 * @create: 2019-04-18 19:42
 **/
public class Sword17_Mirror {

    /**
     * 从上到下,先交换根节点的左右节点，然后对根节点的左右节点递归进行交换
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;

        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }


}
