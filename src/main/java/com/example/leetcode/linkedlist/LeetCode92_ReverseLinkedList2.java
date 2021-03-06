package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 反转链表2
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @author: icecrea
 * @create: 2019-01-07 20:19
 **/
public class LeetCode92_ReverseLinkedList2 {
    /**
     * 思路 ：注意保存反转链表的头节点的前一个节点
     * 注意反转后对原链表的拼接
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 最终为 m 位置的前一点
        ListNode mPre = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            mPre = mPre.next;
        }
        reversePart(mPre, n - m);
        return dummyHead.next;
    }


    /**
     * 从mPre节点的下一个节点开始反转，反转其中size个
     *
     * @param mPre
     * @param size
     */
    private void reversePart(ListNode mPre, int size) {
        ListNode cur = mPre.next;
        ListNode next = cur.next;
        ListNode nNext = next;
        for (int i = 0; i < size; i++) {
            // 进行反转
            nNext = next.next;
            next.next = cur;
            // 移动到下一个反转处
            cur = next;
            next = nNext;
        }


        // 反转完毕，mPre的next对应的节点，是反转前这段的头节点，反转后这段的尾节点，next指向最后一段头节点
        mPre.next.next = nNext;
        //将mpre的next节点，指向反转后的尾节点，应该是现在该段的头节点
        mPre.next = cur;
    }

}
