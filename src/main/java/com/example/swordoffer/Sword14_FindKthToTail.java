package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author: icecrea
 * @create: 2019-04-18 13:26
 **/
public class Sword14_FindKthToTail {

    /**
     * 用例:
     * 6,{1,2,3,4,5}
     * <p>
     * 对应输出应该为:
     * <p>
     * {}
     * <p>
     * 你的输出为:
     * <p>
     * {1,2,3,4,5}
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (len < k) {
            return null;
        }
        for (int i = 0; i < len - k; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 倒数第k个订单，快指针先走k-1步
     * 注意终止条件是 fast.next !=null
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
