package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * @author: icecrea
 * @create: 2018-12-27 10:05
 **/
public class LeetCode61_RotateList {
    /**
     * 遍历一遍找到链表长度size 将k%size 对应的倒数节点做处理
     * 尾节点接到首节点 旋转节点的前一个节点next指向null
     * 返回旋转节点为新头节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }

        //链尾指向头节点
        cur.next = head;

        //链表小于size的 向右移动步数
        k = size - k % size;

        cur = head;
        for (int i = 1; i < k; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;

        return newHead;
    }
}
