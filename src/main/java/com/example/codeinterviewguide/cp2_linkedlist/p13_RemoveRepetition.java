package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.util.HashSet;

/**
 * @description: 删除无序单链表中值重复出现的节点
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p13_RemoveRepetition {
    public static void removeRep1(ListNode head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode pre = head;
        ListNode cur = head.next;
        set.add(head.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    public static void removeRep2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.val == next.val) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

}
