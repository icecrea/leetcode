package com.example.leetcode.linkedlist.medium;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 对链表进行插入排序
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * <p>
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author: icecrea
 * @create: 2019-01-03 20:57
 **/
public class LeetCode147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        //通过dummy节点构造链表
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            pre = dummy;
            //找到插入的位置的前一个节点pre
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //在pre与pre.next之间插入cur
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }

        //不能返回head head节点可能会被移动
        return dummy.next;
    }
}
