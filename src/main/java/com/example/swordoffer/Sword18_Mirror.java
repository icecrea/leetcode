package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.Stack;

/**
 * @description: 二叉树的镜像 翻转二叉树
 * leetCode226
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 * @author: icecrea
 * @create: 2019-04-18 19:42
 **/
public class Sword18_Mirror {

    /**
     * 从上到下,先交换根节点的左右节点，然后对根节点的左右节点递归进行交换
     *
     * @param root
     */
    public void MirrorRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;

        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * 非递归解法 队列和栈都可以
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            //左子树不为空或者右子树不为空，都需要交换
            if (node.left != null || node.right != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }


}
