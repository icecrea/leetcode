package com.example.leetcode.linkedlist.medium;

import com.example.leetcode.linkedlist.pojo.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @description: 两数相加2
 * <p>
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * @author: icecrea
 * @create: 2019-01-01 18:10
 **/
public class LeetCode445_AddTwoNumbers2 {

    /**
     * 翻转链表法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;

        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        int plus = 0;

        while (r1 != null || r2 != null) {
            int a = r1 == null ? 0 : r1.val;
            int b = r2 == null ? 0 : r2.val;
            int sum = a + b + plus;
            plus = sum / 10;

            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;

            if (r1 != null) {
                r1 = r1.next;
            }
            if (r2 != null) {
                r2 = r2.next;
            }
        }

        if (plus > 0) {
            cur.next = new ListNode(plus);
        }

        ListNode reverse = reverse(head.next);

        return reverse;
    }

    /**
     * 使用栈
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int plus = 0;
        Stack<Integer> s = new Stack();
        while (!s1.empty() || !s2.empty()) {
            int a = s1.empty() ? 0 : s1.pop();
            int b = s2.empty() ? 0 : s2.pop();
            int sum = a + b + plus;

            //其实此处不需要第三个栈了 可以直接构建链表 可见下面3
            s.push(sum % 10);

            plus = sum / 10;
        }

        if (plus > 0) {
            s.push(plus);
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;

        while (!s.empty()) {
            cur.next = new ListNode(s.pop());
            cur = cur.next;
        }
        return head.next;
    }

    /**
     * 2做简化 不需要第三个栈，直接在循环中从后往前构造链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int plus = 0;

        ListNode list = null;
        while (!s1.empty() || !s2.empty()) {
            int a = s1.empty() ? 0 : s1.pop();
            int b = s2.empty() ? 0 : s2.pop();
            int sum = a + b + plus;
            ListNode head = new ListNode(sum % 10);
            head.next = list;
            list = head;

            plus = sum / 10;
        }

        if (plus > 0) {
            ListNode head = new ListNode(plus);
            head.next = list;
            list = head;
        }

        return list;
    }


    /**
     * 3的优化 对进位的处理 在链表构造中，即考虑了进位的情况，不需要专门的进位标志
     * 因为题设链表首位保证了不为0 所以最后根据0判断是否有多余的进位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                sum += s1.pop();
            }
            if (!s2.empty()) {
                sum += s2.pop();
            }
            //考虑进位情况 直接在循环中处理
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;

            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }

    public ListNode reverse(ListNode head) {
        //递归终止条件
        if (head.next == null || head == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    @Test
    public void test() {
        String s = "3999999999";
        String s2 = "7";
        Long sum = Long.valueOf(s) + Long.valueOf(s2);
        System.out.println(sum);
    }

    @Test
    public void test2() {
        Stack<Integer> s1 = new Stack();
        int a = s1.peek() == null ? 0 : s1.pop();
    }
}
