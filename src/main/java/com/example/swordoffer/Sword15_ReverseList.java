package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author: icecrea
 * @create: 2019-04-18 18:39
 **/
public class Sword15_ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        ListNode next;
        while (q != null) {
            next = q.next;
            q.next = p;
            p = q;
            q = next;
        }
        return p;
    }

    private ListNode reverse(ListNode head) {
        //递归终止条件： 找到链表最后一个节点 注意空链表
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverse(head.next);
        head.next.next = head;
        //反转头节点的next指针，将头节点作为尾节点
        head.next = null;
        return newNode;
    }
}
