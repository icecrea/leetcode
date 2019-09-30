package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 在单链表和双链表中删除倒数第K个节点
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p02_RemoveLastKthNode {

    /**
     * 单链表
     *
     * @param head
     * @param lastKth
     * @return
     */
    public static ListNode removeLastKthNode(ListNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


}
