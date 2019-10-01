package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 按照左右半区的方式重新组合单链表
 * 如果N为奇数，前N/2个节点是左半区，后N/2+1个节点是右半区
 * 将链表调整成L1-R1-L2-R2的形式
 * 如： 1-2-3-4-null 调整后 1-3-2-4-null
 * 如： 1-2-3-4-5-null 调整后 1-3-2-4-5-null
 * 如： 1-2-3-4-5-6-null 调整后 1-4-2-5-3-6-null
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p20_RelocateLinkedList {
    public static void relocate(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //mid 代表下标为第n/2-1个节点 慢指针从第一个节点开始，步长为1， 快指针从第二个节点开始步长2，走的距离是慢指针两倍
        ListNode mid = head;
        ListNode right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
    }

    public static void mergeLR(ListNode left, ListNode right) {
        ListNode next;
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;

            left = right.next;
            right = next;
        }
        left.next = right;
    }
}
