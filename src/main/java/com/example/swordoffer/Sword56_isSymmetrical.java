package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.Stack;

/**
 * @description: 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author: icecrea
 * @create: 2019-09-11 13:00
 **/
public class Sword56_isSymmetrical {

    /**
     * 可以对比剑指offer17题分析
     *
     * @param pRoot
     * @return
     * @see Sword17_Mirror
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }

    private boolean comRoot(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }


    /**
     * 非递归实现
     * @param pRoot
     * @return
     */
    boolean isSymmetricalDFS(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while (!s.empty()) {
            //成对取出
            TreeNode right = s.pop();
            TreeNode left = s.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }

}
