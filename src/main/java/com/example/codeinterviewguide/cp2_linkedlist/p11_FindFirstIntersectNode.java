package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 两个链表相交的一系列问题
 * 给定两个链表，如果相交，返回相交的第一个节点 链表长度分别为N,M 时间复杂度要求O(M+N),空间复杂度O(1)
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p11_FindFirstIntersectNode {


    /**
     * 问题拆解：
     * 1.判断链表是否有环，有返回第一个进入环的节点，否则返回Null
     * 2.判断两个无环链表是否相交
     * 3.判断两个有环链表是否相交
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode getIntersectNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        //链表1、2的入环节点
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    /**
     * 链表环入口
     *
     * @param head
     * @return
     */
    public static ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * 无环链表如果相交，尾节点必定相同。记录两个链表的长度差，较长链表先走差值大小
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        // n记录长度差值
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //尾节点不同，没有相交直接返回
        if (cur1 != cur2) {
            return null;
        }
        //长度较长链表赋值给cur1
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1;
        ListNode cur2;
        //链表12的入环节点相同，可以类比无环链表相交情况求交点
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
