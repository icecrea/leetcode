package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 按照左右半区的方式重新组合单链表
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p20_RelocateLinkedList {
    public static void relocate(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = head;
        ListNode right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
    }

    public static void mergeLR(ListNode left, ListNode right) {
        ListNode next = null;
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }
}
