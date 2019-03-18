package com.example.topinterview.easy.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;
import org.junit.Test;

/**
 * @description: 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author: icecrea
 * @create: 2019-03-18 09:37
 **/
public class array45_isPalindrome {
    /**
     * 不能对整个链表进行反转 这样会改变原链表的结构 无法后续匹配比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点 快指针的下个和下下个均不能为空
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //注意反转后半部分
        slow = reverse(slow.next);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(0);
        ListNode node2 = new ListNode(0);
        node.next = node2;
        node2.next = null;
        isPalindrome(node);
    }

}
