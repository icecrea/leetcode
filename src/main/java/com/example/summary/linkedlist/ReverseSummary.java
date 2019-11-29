package com.example.summary.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 链表题目小结
 *
 * 反转系列：
 * 1.反转整个链表
 * 2.反转链表前n个节点
 * 3.反转链表后n个节点
 * 4.反转链表其中一部分
 * 5.反转链表相邻节点
 * 6.反转链表k个一组
 */
public class ReverseSummary {

    /**
     * 1.反转整个链表 非递归
     */
    public ListNode reverseAllList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 1.反转整个链表 递归
     */
    public ListNode reverseAllListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseAllListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 2.反转链表前n个节点 非递归
     */
    public ListNode reverseN(ListNode head, int n) {
        ListNode nNext = head;
        for (int i = 0; i < n; i++) {
            nNext = nNext.next;
        }
        ListNode pre = null;
        ListNode next;
        ListNode cur = head;
        while (cur != nNext) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = nNext;
        return pre;
    }


    ListNode nNext = null; // 后驱节点

    /**
     * 2.反转链表前n个节点 递归
     */
    public ListNode reverseNRecur(ListNode head, int n) {
        // n==1则走到了第n个节点，找到第n+1个节点
        if (n == 1) {
            nNext = head.next;
            return head;
        }
        ListNode last = reverseNRecur(head.next, n - 1);
        head.next.next = head;
        head.next = nNext;
        return last;
    }

    /**
     * 3.反转链表后n个节点 非递归
     */
    public ListNode reverseLastN(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode cur = slow.next;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        slow.next = pre;
        return head;
    }

    /**
     * 4.反转链表其中一部分 从第from个节点到第to个节点的部分
     */
    public static ListNode reversePart(ListNode head, int from, int to) {
        int len = 0;
        ListNode cur = head;
        ListNode startPre = null;
        ListNode end = null;
        while (cur != null) {
            len++;
            if (len == from - 1) {
                startPre = cur;
            }
            if (len == to) {
                end = cur;
            }
            cur = cur.next;
        }

        //考虑from是1的情况
        ListNode start = startPre == null ? head : startPre.next;
        ListNode endNext = end.next;

        cur = start;
        ListNode pre = null;
        ListNode next;
        while (cur != endNext) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (startPre != null) {
            startPre.next = pre;
        } else {
            head = pre;
        }
        start.next = endNext;
        return head;
    }

    /**
     * 5.反转链表相邻节点 非递归
     */
    public ListNode reverseInPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode p = cur.next;
            ListNode q = cur.next.next;

            cur.next = q;
            p.next = q.next;
            q.next = p;
            cur = p;
        }
        return dummy.next;
    }


    /**
     * 5.反转链表相邻节点 递归
     */
    public ListNode reverseInPairsRecur(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode next = head.next;
        head.next = reverseInPairsRecur(head.next.next);
        next.next = head;
        return next;
    }

    /**
     * k个一组反转链表
     */
    public ListNode reverseK(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                pre = resign1(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    public static ListNode resign1(Stack<ListNode> stack, ListNode left, ListNode right) {
        ListNode cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        ListNode next;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        addNode(head, new ListNode(2));
        addNode(head, new ListNode(3));
        addNode(head, new ListNode(4));
        addNode(head, new ListNode(5));
//        head = reverseAllList(head);
//        head = reverseAllListRecur(head);
//        head = reverseN(head, 3);
//        head = reverseNRecur(head, 3);
//        head = reverseLastN(head, 3);
//        head = reversePart(head, 3, 5);
//        head = reverseInPairsRecur(head);
        head = reverseInPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void addNode(ListNode head, ListNode node) {
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
    }


}
