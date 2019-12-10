package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @description: 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @author: icecrea
 * @create: 2019-01-08 13:52
 **/
public class LeetCode143_ReorderList {
    /**
     * 使用双向链表
     *
     * @param head
     */
    public void reorderList2(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
    }

    /**
     * 一开始思路错误，不能对链表进行全部翻转，可以对后半段反转
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将链表从中间拆成两段, 并对后半部分节点进行翻转
        ListNode secondHead = reverse(slow.next);
        slow.next = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = secondHead;
            if (secondHead != null) {
                secondHead = secondHead.next;
            } else {
                break;
            }
            cur.next.next = next;
            cur = next;
        }

    }

    /**
     * 翻转链表
     *
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 遍历到最后,cur和next都为空, 原来的尾节点即新的头结点为pre所指向的节点
        return pre;
    }


    @Test
    public void test() {
        ListNode cur = new ListNode(1);
        ListNode cur2 = new ListNode(2);
        ListNode cur3 = new ListNode(3);
        ListNode cur4 = new ListNode(4);
        cur.next = cur2;
        cur2.next = cur3;
        cur3.next = cur4;

//        reorderList2(cur);

        System.out.println(cur.val);
        System.out.println(cur.next.val);
        System.out.println(cur.next.next.val);
        System.out.println(cur.next.next.next.val);


    }
}
