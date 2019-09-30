package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 打印两个有续链表公共部分
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p01_PrintCommonPart {

    /**
     * 较小值链表指针后移，直到链表大小相等
     *
     * @param head1
     * @param head2
     */
    public static void printCommonPart(ListNode head1, ListNode head2) {
        System.out.print("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.print(head1.val + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
