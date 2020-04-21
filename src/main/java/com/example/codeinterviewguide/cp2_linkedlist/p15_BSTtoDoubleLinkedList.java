package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 将搜索二叉树转换成双向链表
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p15_BSTtoDoubleLinkedList {


    public static TreeNode convert1(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        TreeNode pre = head;
        pre.left = null;
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public static void inOrderToQueue(TreeNode head, Queue<TreeNode> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

    public static TreeNode convert2(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }

    public static TreeNode process(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode leftE = process(head.left); // left end
        TreeNode rightE = process(head.right); // right end
        TreeNode leftS = leftE != null ? leftE.right : null; // left start
        TreeNode rightS = rightE != null ? rightE.right : null; // right start
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }
    }

}
