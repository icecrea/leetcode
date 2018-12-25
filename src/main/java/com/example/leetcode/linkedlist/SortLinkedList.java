package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.awt.*;

/**
 * @description: Sort a linked list in O(n log n) time using constant space complexity.
 * @author: icecrea
 * @create: 2018-12-18 15:28
 **/
public class SortLinkedList {

    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode listNodeLeft = sortList(head);
        ListNode listNodeRight = sortList(midNext);
        return mergeSort(listNodeLeft, listNodeRight);
    }

    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    private ListNode mergeSort(ListNode n1, ListNode n2) {
        ListNode preHead = new ListNode(0);
        ListNode cur1 = n1;
        ListNode cur2 = n2;
        ListNode cur = preHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return preHead.next;
    }

}

