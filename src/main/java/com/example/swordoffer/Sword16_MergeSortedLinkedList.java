package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 合并两个排序的链表
 * @author: icecrea
 * @create: 2019-11-07
 **/
public class Sword16_MergeSortedLinkedList {

    public ListNode Merge(ListNode p, ListNode q) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                head.next = p;
                p = p.next;
                head = head.next;
            } else {
                head.next = q;
                q = q.next;
                head = head.next;
            }
        }
        if (p == null) {
            head.next = q;
        } else if (q == null) {
            head.next = p;
        }
        return dummy.next;
    }
}
