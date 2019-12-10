package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 单链表的选择排序
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p16_ListSelectionSort {
    /**
     * 时间复杂度O（N^2） 空间复杂度O（1）
     * 选择排序：从未排序的的部分找到最小值，放在排好序部分的尾部，逐渐缩小未排序部分直到全部有序
     *
     * @param head
     * @return
     */
    public ListNode selectionSort(ListNode head) {
        //排序部分尾部
        ListNode end = null;
        //未排序部分头部
        ListNode cur = head;
        ListNode smallPre;
        ListNode small;
        while (cur != null) {
            small = cur;
            smallPre = getsmallPreListNode(cur);
            //删除最小节点
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (end == null) {
                head = small;
            } else {
                end.next = small;
            }
            end = small;
        }
        return head;
    }

    /**
     * 返回以head为头节点的链表，最小节点的前置节点
     * 如果最小节点是头节点 返回的是null
     *
     * @param head
     * @return
     */
    public ListNode getsmallPreListNode(ListNode head) {
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
