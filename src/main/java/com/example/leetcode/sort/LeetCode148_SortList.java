package com.example.leetcode.sort;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author: icecrea
 * @create: 2019-03-27 09:48
 **/
public class LeetCode148_SortList {
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
