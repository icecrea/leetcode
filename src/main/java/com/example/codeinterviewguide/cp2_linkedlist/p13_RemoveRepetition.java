package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.util.HashSet;

/**
 * @description: 删除无序单链表中值重复出现的节点
 * 如 1-2-3-3-4-4-2-1-1-null 删除重复之后为 1-2-3-4-null
 * 要求两种方法 1.时间复杂O（N） 方法二2.额外空间复杂度O（1）
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p13_RemoveRepetition {
    /**
     * 哈希表 时间复杂度O1 空间复杂度On
     * @param head
     */
    public static void removeRep1(ListNode head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
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

    /**
     * 时间复杂度On^2 空间复杂度O1
     * @param head
     */
    public static void removeRep2(ListNode head) {
        ListNode cur = head;
        ListNode pre;
        ListNode next;
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
