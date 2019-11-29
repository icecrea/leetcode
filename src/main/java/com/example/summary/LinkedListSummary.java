package com.example.summary;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * 链表题目小结
 *
 * 反转系列：
 * 1.反转整个链表
 * 2.反转链表前n个节点
 * 3.反转链表后n个节点
 * 4.反转链表其中一部分
 * 5.反转链表相邻节点
 */
public class LinkedListSummary {

    /**
     * 1.反转整个链表 非递归
     */
    public ListNode reverseAllList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 1.反转整个链表 递归
     */
    public ListNode reverseAllListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseAllListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 2.反转链表前n个节点 非递归
     */
    public ListNode reverseN(ListNode head, int n) {
        ListNode nNext = head;
        for (int i = 0; i < n; i++) {
            nNext = nNext.next;
        }
        ListNode pre = null;
        ListNode next;
        ListNode cur = head;
        while (cur != nNext) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = nNext;
        return pre;
    }


    ListNode nNext = null; // 后驱节点

    /**
     * 2.反转链表前n个节点 递归
     */
    public ListNode reverseNRecur(ListNode head, int n) {
        // n==1则走到了第n个节点，找到第n+1个节点
        if (n == 1) {
            nNext = head.next;
            return head;
        }
        ListNode last = reverseNRecur(head.next, n - 1);
        head.next.next = head;
        head.next = nNext;
        return last;
    }


}
