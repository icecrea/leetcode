package com.example.topinterview.easy.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * @author: icecrea
 * @create: 2019-03-18 10:00
 **/
public class array46_hasCycle {

    /**
     * 假设链表的起始点到环的入口点的距离为L，环的周长为R，环的入口点到快慢指针的相遇位置的距离为X（图中红色箭头标注的就是快慢指针的相遇点）。
     * <p>
     * 快指针走的距离：F = L+X+n*R
     * <p>
     * 慢指针走的距离：S = L+X
     * <p>
     * 注意：慢指针一定是走不到一圈就相遇了，因为如果在环的入口点没有相遇的话，快指针的速度是慢指针的两倍，
     * 慢指针在入口点时快指针已经进入环内，在慢指针走完一圈之前，快指针一定会追上它。最差的情况就是在入口点相遇，
     * 这是快指针走了两圈，慢指针刚好走了一圈
     * <p>
     * 因为快指针走的距离是慢指针的两倍，所以F = 2*S
     * <p>
     * 这时：L+X+n*R = 2 * (L + X)
     * <p>
     * L = n*R - X
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
