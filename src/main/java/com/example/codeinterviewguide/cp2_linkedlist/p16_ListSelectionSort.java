package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 单链表的选择排序
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p16_ListSelectionSort {
    public static ListNode selectionSort(ListNode head) {
        ListNode tail = null; // sorted part tail
        ListNode cur = head; // unsorted part head
        ListNode smallPre = null; // previous node of the smallest node
        ListNode small = null; // smallest node
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreListNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    public static ListNode getSmallestPreListNode(ListNode head) {
        ListNode smallPre = null;
        ListNode small = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val < small.val) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
