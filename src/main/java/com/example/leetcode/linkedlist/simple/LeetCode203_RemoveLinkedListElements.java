package com.example.leetcode.linkedlist.simple;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 移除链表元素
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @author: icecrea
 * @create: 2018-12-27 17:02
 **/
public class LeetCode203_RemoveLinkedListElements {
    /**
     * 设置哑节点，next连到头节点，
     * 然后遍历当前节点的next值与val是否相等,便于删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;

        ListNode cur = newHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
