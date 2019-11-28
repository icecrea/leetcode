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
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
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

    /**
     * reverse(head) 定义：
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     *
     */
    public static ListNode reverse(ListNode head) {
        //递归终止条件： 找到链表最后一个节点
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        //反转头节点的下一个节点的next指针 head.next对应的是 反转后链表的尾指针，而node.next是反转后的头指针的下一个节点，此处注意区分
        head.next.next = head;
        //反转头节点的next指针，将头节点作为尾节点
        head.next = null;
        return last;
    }

}
