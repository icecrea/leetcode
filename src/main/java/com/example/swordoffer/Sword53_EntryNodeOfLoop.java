package com.example.swordoffer;

import com.example.leetcode.linkedlist.medium.LeetCode142_LinkedListCycle2;
import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author: icecrea
 * @create: 2019-09-11 12:58
 **/
public class Sword53_EntryNodeOfLoop {

    /**
     * 思路参考 LEETCODE142题
     * @see LeetCode142_LinkedListCycle2
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            ListNode p = pHead;
            while (p != slow) {
                p = p.next;
                slow = slow.next;
            }
        }

        return slow;
    }
}
