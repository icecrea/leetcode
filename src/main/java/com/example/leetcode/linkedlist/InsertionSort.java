package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;
import org.junit.Test;

import java.util.Random;

/**
 * @description:
 * @author: icecrea
 * @create: 2018-12-18 18:42
 **/
public class InsertionSort {

    /**
     * Sort a linked list using insertion sort.
     */
//    public ListNode insertionSortList(ListNode head) {
//        ListNode node = head;
//        ListNode nodeNext = head.next;
//        while (nodeNext != null) {
//            if (node.val > nodeNext.val) {
//
//                ListNode cur = head;
//                ListNode curNext = head.next;
//                while (cur.next != null) {
//                    if (nodeNext.val < cur.val){
//                        head.val
//                    }
//
//                    cur = cur.next;
//                    curNext = curNext.next;
//                }
//            }
//
//            node = node.next;
//            nodeNext = nodeNext.next;
//        }
//    }
    public ListNode insertionSortList(ListNode head) {
        //哑节点
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dumy;
        while (cur != null) {
            //保存当前节点下一个节点
            ListNode next = cur.next;
            pre = dumy;
            //寻找当前节点正确位置的一个节点 把pre移动到正确的位置，cur要插入pre之后
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //将当前节点cur加入新链表中 pre之后
            cur.next = pre.next;
            pre.next = cur;
            //处理下一个节点
            cur = next;
        }
        return dumy.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode c = head.next;  //未排序游动指针C
        head.next = null;
        ListNode pt, h;   //pt:临时节点指针，h：已排序部分游动指针

        while (c != null) {

            pt = c;
            c = c.next;
            pt.next = null;

            if (head.val > pt.val) { //比较头部
                pt.next = head;
                head = pt;
                continue;
            }

            h = head;
            while (h.next != null) { //比较有序部分
                if (h.next.val > pt.val) {
                    pt.next = h.next;
                    h.next = pt;
                    break;
                }

                h = h.next;
            }

            if (h.next == null) { //追加末尾
                h.next = pt;
            }
        }

        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < 5; i++) {
            ListNode listNode = new ListNode((int) (100 * Math.random()));
            cur.next = listNode;
            cur = cur.next;
        }

        cur = head;
        while (cur.next != null) {
            cur = cur.next;
            System.out.println(cur.val);
        }

        ListNode listNode = insertionSortList(head);
        cur = listNode;
        while (cur.next!= null){
            cur=cur.next;
            System.out.println(cur.val);
        }

    }

    public ListNode insertionSort(ListNode head) {
        if(head == null || head.next==null) {
            return head;
        }
        ListNode newHead = new ListNode(head.val);
        ListNode index = head.next;
        while (index != null) {
            ListNode lastNode = null;
            ListNode node = newHead;
            while (node != null && index.val > node.val) {
                lastNode = node;
                node = node.next;
            }
            ListNode newNode = new ListNode(index.val);
            if (lastNode != null) {
                lastNode.next = newNode;
            } else {
                newHead = newNode;
            }
            newNode.next = node;
            index = index.next;
        }
        return newHead;
    }

}
