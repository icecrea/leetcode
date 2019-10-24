package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.Stack;

/**
 * @description: 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author: icecrea
 * @create: 2019-04-22 12:52
 **/
public class Sword25_BSTToDoubleLinkedList {

    public TreeNode ConvertBSTToBiList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        // 用于保存中序遍历序列的上一节点
        TreeNode pre = null;
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (isFirst) {
                // 将中序遍历序列中的第一个节点记为root
                root = p;
                pre = root;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }


    private TreeNode head = null;
    private TreeNode last = null;

    public TreeNode Convert(TreeNode root) {
        visit(root);
        return head;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private void visit(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root.left);
        createList(root);
        visit(root.right);
    }

    /**
     * 建表
     *
     * @param node
     */
    private void createList(TreeNode node) {
        //当前结点左结点连接上一个
        node.left = last;
        //为空说明当前结点是第一个结点
        if (last == null) {
            head = node;
        } else {
            //不为空要将当前结点赋给上个结点的右结点
            last.right = node;
        }
        //更新last
        last = node;
    }

}
