package com.example.swordoffer;

/**
 * @description: 二叉树下一个节点
 * <p>
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author: icecrea
 * @create: 2019-09-11 12:59
 **/
public class Sword55_GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {

        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

