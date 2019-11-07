package com.example.swordoffer;

import com.example.leetcode.linkedlist.medium.LeetCode82_RemoveDuplicatesFromSortedList2;
import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 删除链表中重复的节点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author: icecrea
 * @create: 2019-09-11 12:58
 **/
public class Sword56_DeleteDuplication {

    /**
     * 参考leetcode 82题
     *
     * @param pHead
     * @return
     * @see LeetCode82_RemoveDuplicatesFromSortedList2
     * 难点在
     * 1.多个重复节点的删除
     * 2.删除节点前一个指针的保存
     * <p>
     * 因为要删除所有重复的元素而并非留一个，所以要考虑头节点删除，留出pre指针，比较后两个大小是否相等
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = pHead;
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
                //移动指针指向，不真正移动指针，指针的移动在不同时候
                pre.next = lastSame.next;
            }
        }
        return dummy.next;
    }
}
