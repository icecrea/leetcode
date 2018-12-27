package com.example.leetcode.linkedlist.medium;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * @author: icecrea
 * @create: 2018-12-24 20:39
 **/
public class LeetCode19_RemoveNthNodeFromEnd {

    /**
     * 两个指针 一个比另一个快n步 快指针到终点，慢指针指向被移除节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode low = head;
        ListNode lowPre = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast != null) {
            while (fast != null) {
                fast = fast.next;
                if (fast == null) {
                    lowPre = low;
                }
                low = low.next;
            }
            //删除节点
            lowPre.next = low.next;
        } else {
            head = head.next;
        }

        return head;
    }

    /**
     * 这个问题可以容易地简化成另一个问题：
     * 删除从列表开头数起的第 (L - n + 1)(L−n+1) 个结点，其中 LL 是列表的长度。
     * 只要我们找到列表的长度 LL，这个问题就很容易解决
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }


    /**
     * 方法同第一个，设置快慢指针，只不过这次找到被移除节点的前一个节点
     * 这样可以快速移除操作
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
