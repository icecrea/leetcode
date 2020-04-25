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


    public static TreeNode convert(TreeNode head) {
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
}
