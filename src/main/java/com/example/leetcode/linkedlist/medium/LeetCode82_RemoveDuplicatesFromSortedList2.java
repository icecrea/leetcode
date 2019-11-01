package com.example.leetcode.linkedlist.medium;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 删除链表重复元素2
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * @author: icecrea
 * @create: 2019-01-07 19:46
 **/
public class LeetCode82_RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        //因为要删除所有重复的元素而并非留一个，所以要考虑头节点删除，留出pre指针，比较后两个大小是否相等
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val != pre.next.next.val) {
                pre = pre.next;
                continue;
            } else {
                ListNode lastSame = pre.next.next;
                while (lastSame.next != null && pre.next.val == lastSame.next.val) {
                    lastSame = lastSame.next;
                }
                //移动指针指向，不真正移动指针，指针的移动在不同时候 比如：有可能存在54448889这种情况
                pre.next = lastSame.next;
            }
        }
        return dummy.next;
    }
}
