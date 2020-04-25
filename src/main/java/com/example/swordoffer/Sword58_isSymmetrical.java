package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.Stack;

/**
 * @description: 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author: icecrea
 * @create: 2019-09-11 13:00
 **/
public class Sword58_isSymmetrical {

    /**
     * @see Sword18_Mirror
     */
    boolean isSymmetrical(TreeNode root){
        if(root ==null){
            return true;
        }
        return isSame(root.left, root.right);
    }

    boolean isSame(TreeNode left,TreeNode right){
        if(left ==null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSame(left.left, right.right) && isSame(left.right, right.left);
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
