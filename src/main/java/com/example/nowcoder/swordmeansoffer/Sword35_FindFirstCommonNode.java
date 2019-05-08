package com.example.nowcoder.swordmeansoffer;

import com.example.leetcode.linkedlist.pojo.ListNode;


/**
 * @description: 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。
 * @author: icecrea
 * @create: 2019-05-08 22:32
 **/
public class Sword35_FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 两连表的长度差

        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }
        } else if (length1 < length2) {
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }

        //开始齐头并进，直到找到第一个公共结点
        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1;

    }

    // 求指定链表的长度
    public int getLength(ListNode pHead) {
        int length = 0;

        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
