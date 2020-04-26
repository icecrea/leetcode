package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @author: icecrea
 * @create: 2018-12-27 10:45
 **/
public class LeetCode86_PartitionList {

    /**
     * 新建两个链表，一个存大于x ，一个存小于x，最后连接到一起
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode pHead = new ListNode(Integer.MIN_VALUE);
        ListNode qHead = new ListNode(Integer.MIN_VALUE);

        ListNode p = pHead;
        ListNode q = qHead;

        while (head != null) {
            if (head.val < x) {
                p.next = new ListNode(head.val);
                p = p.next;
            } else {
                q.next = new ListNode(head.val);
                q = q.next;
            }
            head = head.next;
        }

        p.next = qHead.next;

        return pHead.next;
    }
}
