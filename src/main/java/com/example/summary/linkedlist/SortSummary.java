package com.example.summary.linkedlist;

import com.example.codeinterviewguide.cp2_linkedlist.p16_ListSelectionSort;
import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * 链表排序专题总结
 *
 * 1.链表选择排序
 * 2.将链表划按某值划分成左边小，中间相等，右边大的形式
 * 1.一个链表，奇数位升序偶数位降序，让链表变成升序的
 */
public class SortSummary {

    /**
     * 1.单链表选择排序
     * 选择排序：从未排序的的部分找到最小值，放在排好序部分的尾部，逐渐缩小未排序部分直到全部有序
     *
     * @see p16_ListSelectionSort
     */
    public static ListNode selectionSort(ListNode head) {
        ListNode tail = null;
        ListNode cur = head;
        ListNode smallPre;
        ListNode small;
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreListNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    /**
     * 返回以head为头节点的链表，最小节点的前置节点
     * 如果最小节点是头节点 返回的是null
     */
    public static ListNode getSmallestPreListNode(ListNode head) {
        ListNode smallPre = null;
        ListNode small = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val < small.val) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
