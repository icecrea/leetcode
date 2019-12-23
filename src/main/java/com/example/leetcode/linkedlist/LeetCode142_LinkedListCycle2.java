package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 环形链表2
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * @author: icecrea
 * @create: 2018-12-29 12:05
 **/
public class LeetCode142_LinkedListCycle2 {

    /**
     * 相遇时候 快指针距离2n 慢指针距离n
     * 假设 A - B -C  B是环入口 C是快慢相遇点
     * AC = AB +  BC =n
     * 此刻慢指针再走n步会回到c点 ，即BC + CB =n
     * 说明AB = CB
     * 此刻设置头指针 当头指针到环入口时， 慢指针也同时到环入口
     * 如果表头是环入口点 ，此刻慢指针也在入口点，不用特殊考虑
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // 步骤一：使用快慢指针判断链表是否有环
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // 步骤二：若有环，找到入环开始的节点
        if (hasCycle) {
            ListNode cur = head;
            while (slow != cur) {
                cur = cur.next;
                slow = slow.next;
            }
            return slow;
        }

        return null;
    }
}
