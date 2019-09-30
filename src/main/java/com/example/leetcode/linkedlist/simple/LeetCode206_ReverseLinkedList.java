package com.example.leetcode.linkedlist.simple;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author: icecrea
 * @create: 2018-12-27 11:42
 **/
public class LeetCode206_ReverseLinkedList {
    /**
     * 非递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = p.next;
        head.next = null;
        ListNode next;

        while (q != null) {
            //因为有指针反转，所以需要提前保留下一个step要处理的指针
            next = q.next;
            //指针反转
            q.next = p;
            //后移一位
            p = q;
            q = next;
        }
        return p;
    }


    /**
     * 递归方法
     * @param head
     * @return
     */
    public ListNode reverseListRecur(ListNode head) {
        //递归终止条件： 找到链表最后一个节点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseListRecur(head.next);
        //反转头节点的下一个节点的next指针 head.next对应的是 反转后链表的尾指针，而node.next是反转后的头指针的下一个节点，此处注意区分
        head.next.next = head;
        //反转头节点的next指针，将头节点作为尾节点
        head.next = null;
        return newNode;
    }

}
