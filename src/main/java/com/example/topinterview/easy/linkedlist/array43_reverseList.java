package com.example.topinterview.easy.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;
import org.junit.Test;

/**
 * @description: 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author: icecrea
 * @create: 2019-03-17 22:47
 **/
public class array43_reverseList {
    /**
     * 递归方法
     * @param head
     * @return
     */
    public ListNode reverseListRecur(ListNode head) {
        //递归终止条件： 找到链表最后一个节点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseListRecur(head.next);
        //反转头节点的下一个节点的next指针 head.next对应的是 反转后链表的尾指针，而node.next是反转后的头指针的下一个节点，此处注意区分
        head.next.next = head;
        //反转头节点的next指针，将头节点作为尾节点
        head.next = null;
        return newNode;
    }


    @Test
    public void test(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b ;
        b.next = c;
        c.next = null;
        reverseListRecur(a);
    }
}
