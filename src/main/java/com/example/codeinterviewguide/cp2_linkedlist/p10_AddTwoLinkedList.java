package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.util.Stack;

/**
 * @description: 两个单链表生成相加链表
 * 链表中每个节点值在0-9之间，链表整体代表一个数 如9-3-7 代表937
 * 给定head1 head2 生成代表两个整数相加值的结果链表 如 9-3-7 6-3 生成链表为1-0-0-0
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p10_AddTwoLinkedList {
    /**
     * 如果先算整数，求和再转换链表，有溢出风险
     * 利用栈 注意进位
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addLists1(ListNode head1, ListNode head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.val);
            head2 = head2.next;
        }
        int ca = 0;
        int n1;
        int n2;
        int n;
        ListNode node = null;
        ListNode pre;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            //倒插法
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca == 1) {
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return node;
    }

    /**
     * 利用链表的逆序求解 省掉使用栈的空间
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addLists2(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int ca = 0;
        int n1;
        int n2;
        int n;
        ListNode c1 = head1;
        ListNode c2 = head2;
        ListNode node = null;
        ListNode pre;
        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.val : 0;
            n2 = c2 != null ? c2.val : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = n / 10;
            //因为或关系，所以可能存在一方为null，需判空
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }
        if (ca == 1) {
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        reverseList(head1);
        reverseList(head2);
        return node;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
