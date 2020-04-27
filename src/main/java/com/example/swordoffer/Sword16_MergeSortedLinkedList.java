package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 合并两个排序的链表
 * @author: icecrea
 * @create: 2019-11-07
 **/
public class Sword16_MergeSortedLinkedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    /**
     * 合并k个排序链表 分治成n个再2个合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public ListNode partion(ListNode[] lists, int start, int end) {
        //终止条件
        if (start == end) {
            return lists[start];
        }
        int mid = start + ((end - start) >> 1);
        ListNode l1 = partion(lists, start, mid);
        ListNode l2 = partion(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

}
