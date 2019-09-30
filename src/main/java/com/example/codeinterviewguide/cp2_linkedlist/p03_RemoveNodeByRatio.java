package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 删除链表中间节点和a/b节点
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p03_RemoveNodeByRatio {

    /**
     * 删除中间节点
     *
     * @param head
     * @return
     */
    public static ListNode removeMidListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 删除a/b节点
     * @param head
     * @param a
     * @param b
     * @return
     */
    public static ListNode removeByRatio(ListNode head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
