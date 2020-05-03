package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @author: icecrea
 * @create: 2018-12-27 10:45
 **/
public class LeetCode86_PartitionList {

    /**
     * 新建两个链表，一个存大于x ，一个存小于x，最后连接到一起
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode pHead = new ListNode(Integer.MIN_VALUE);
        ListNode qHead = new ListNode(Integer.MIN_VALUE);

        ListNode p = pHead;
        ListNode q = qHead;

        while (head != null) {
            if (head.val < x) {
                p.next = new ListNode(head.val);
                p = p.next;
            } else {
                q.next = new ListNode(head.val);
                q = q.next;
            }
            head = head.next;
        }

        p.next = qHead.next;

        return pHead.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = null;
        head = dummy;
        //找到第一个大于等于分区点的节点，tail 指向它的前边
        while (head.next != null) {
            if (head.next.val >= x) {
                tail = head;
                head = head.next;
                break;
            } else {
                head = head.next;
            }
        }
        while (head.next != null) {
            //如果当前节点小于分区点，就把它插入到 tail 的后边
            if (head.next.val < x) {
                //拿出要插入的节点
                ListNode move = head.next;
                //将要插入的结点移除
                head.next = move.next;
                //将 move 插入到 tail 后边
                move.next = tail.next;
                tail.next = move;
                //更新 tail
                tail = move;
            } else {
                head = head.next;
            }

        }
        return dummy.next;
    }

    /**
     * TODO 确认下正确性
     */
    public ListNode partition3(ListNode head, int x) {
        ListNode cur = head;
        ListNode small = new ListNode(-1);
        ListNode smallStart = small;
        ListNode big = new ListNode(-1);
        ListNode bigStart = big;

        while (cur != null) {
            if(cur.val < x){
                small.next = cur;
                cur = cur.next;
                small = small.next;
            }else {
                big.next = cur;
                cur = cur.next;
                big = big.next;
            }
        }
        small.next = bigStart.next;
        return smallStart;
    }
}
