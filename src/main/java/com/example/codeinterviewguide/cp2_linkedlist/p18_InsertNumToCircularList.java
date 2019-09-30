package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 向有序的环形单链表中插入新节点
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p18_InsertNumToCircularList {

    public static ListNode insertNum(ListNode head, int num) {
        ListNode node = new ListNode(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != head) {
            if (pre.val <= num && cur.val >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.val < num ? head : node;
    }

}
