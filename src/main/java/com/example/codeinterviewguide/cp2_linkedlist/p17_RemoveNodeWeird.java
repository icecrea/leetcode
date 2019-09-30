package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 怪异的删除方式
 * 给定一个链表中节点node,但是不给整个链表头节点 如何删除node
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p17_RemoveNodeWeird {


    /**
     * 删除某个节点需要得到前一个节点的指针，因为我们没有头节点指针，只能另辟蹊径
     * 将node下一个节点的值赋值给node节点，然后删除node的下一个节点。达到“删除node节点"效果。注意对node下一个节点判空
     *
     * @param node
     */
    public static void removeNodeWired(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode next = node.next;
        if (next == null) {
            throw new RuntimeException("can not remove last node.");
        }
        node.val = next.val;
        node.next = next.next;
    }
}
