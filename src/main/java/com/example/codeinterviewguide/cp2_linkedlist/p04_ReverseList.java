package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 反转链表
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p04_ReverseList {

    /**
     * 反转链表简洁版
     * @param head
     * @param next1
     * @return
     */
    public static ListNode reverseList(ListNode head, ListNode next1) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
