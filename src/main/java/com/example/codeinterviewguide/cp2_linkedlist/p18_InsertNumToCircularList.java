package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 向有序的环形单链表中插入新节点
 * 时间复杂度O（N），空间复杂度O（1）
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p18_InsertNumToCircularList {

    public static ListNode insertNum(ListNode head, int num) {
        ListNode node = new ListNode(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        //循环一圈
        while (cur != head) {
            //找到对应的位置
            if (pre.val <= num && cur.val >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        //如果是转了一圈都没满足情况，说明应该插入到头节点前面 如1-3-4-1 num=5 将5插入节点1前 num-0 也应把0插入节点1前 下面条件同样满足
        pre.next = node;
        node.next = cur;
        //如果node节点值比链表头节点值大，返回原来头节点。如果node节点值比头节点小（即比最小节点小），把NODE作为链表新头节点返回
        return head.val < num ? head : node;
    }

}
