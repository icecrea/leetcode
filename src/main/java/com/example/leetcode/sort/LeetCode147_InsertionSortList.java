package com.example.leetcode.sort;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 链表插入排序
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author: icecrea
 * @create: 2019-03-26 09:44
 **/
public class LeetCode147_InsertionSortList {

    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode pre;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            pre = dummy;
            while (pre.next != null && cur.val > pre.next.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }

        return dummy.next;
    }

    /**
     * 归并
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode L = insertionSortList(head);
        ListNode R = insertionSortList(slow);
        return merge(L, R);
    }

    public ListNode merge(ListNode L1, ListNode L2) {
        if (L1 == null) {
            return L2;
        }
        if (L2 == null) {
            return L1;
        }
        if (L1.val < L2.val) {
            L1.next = merge(L1.next, L2);
            return L1;
        } else {
            L2.next = merge(L1, L2.next);
            return L2;
        }

    }


}
