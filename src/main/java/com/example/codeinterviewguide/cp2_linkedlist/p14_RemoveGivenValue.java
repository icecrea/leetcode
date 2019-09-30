package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.util.Stack;

/**
 * @description: 在单链表中删除指定值的节点
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p14_RemoveGivenValue {

    public static ListNode removeValue1(ListNode head, int num) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            if (head.val != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    public static ListNode removeValue2(ListNode head, int num) {
        while (head != null) {
            if (head.val != num) {
                break;
            }
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
