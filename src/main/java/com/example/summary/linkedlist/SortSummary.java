package com.example.summary.linkedlist;

import com.example.codeinterviewguide.cp2_linkedlist.p08_SmallerEqualBigger;
import com.example.codeinterviewguide.cp2_linkedlist.p16_ListSelectionSort;
import com.example.codeinterviewguide.cp2_linkedlist.p20_RelocateLinkedList;
import com.example.leetcode.linkedlist.pojo.ListNode;
import com.example.leetcode.sort.LeetCode148_SortList;

/**
 * 链表排序专题总结
 *
 * 1.链表归并排序
 * @see LeetCode148_SortList
 * 2.链表选择排序
 * @see p16_ListSelectionSort
 * 3.将链表划按某值划分成左边小，中间相等，右边大的形式
 * @see p08_SmallerEqualBigger
 * 4.按照左右半区的方式重新组合单链表
 * @see p20_RelocateLinkedList
 * 5.一个链表，奇数位升序偶数位降序，让链表变成升序的
 */
public class SortSummary {


    /**
     * 链表归并排序
     * 归并排序的思路是要找到中点，再分解成子问题递归。
     */
    public ListNode sortList(ListNode head) {
        //递归终止条件： 只有一个元素
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sNext = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(sNext);
        return mergeSort(left, right);
    }


    private ListNode mergeSort(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }

    /**
     * 链表选择排序
     * 选择排序：从未排序的的部分找到最小值，放在排好序部分的尾部，逐渐缩小未排序部分直到全部有序
     *
     * @see p16_ListSelectionSort
     */
    public static ListNode selectionSort(ListNode head) {
        //排序部分尾部
        ListNode end = null;
        //未排序部分头部
        ListNode cur = head;
        ListNode smallPre;
        ListNode small;
        while (cur != null) {
            small = cur;
            smallPre = getsmallPreListNode(cur);
            //删除最小节点
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (end == null) {
                head = small;
            } else {
                end.next = small;
            }
            end = small;
        }
        return head;
    }

    /**
     * 返回以head为头节点的链表，最小节点的前置节点
     * 如果最小节点是头节点 返回的是null
     */
    public static ListNode getsmallPreListNode(ListNode head) {
        ListNode smallPre = null;
        ListNode small = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val < small.val) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }

    /**
     * 将链表划按某值划分成左边小，中间相等，右边大的形式
     * 进阶解法：保持相对顺序不变且时间复杂度O(1)
     *
     * @see p08_SmallerEqualBigger
     */
    public static ListNode listPartition(ListNode head, int pivot) {
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;
        ListNode next;
        //所有节点分进三个链表中
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // 小的和相等的拼接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // 全体拼接
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }


    //快速排序
    public static void quickSort(ListNode head, ListNode end) {
        if (head == null || head == end) {
            return;
        }
        ListNode index = paration(head, end);
        quickSort(head, index);
        quickSort(index.next, end);
    }

    /**
     * 划分函数，以头结点值为基准元素进行划分
     *
     * @param head
     * @param end
     * @return
     */
    public static ListNode paration(ListNode head, ListNode end) {
        if (head == null || head == end) {
            return head;
        }
        int val = head.val;
        ListNode index = head, cur = head.next;
        while (cur != end) {
            if (cur.val < val) {
                index = index.next;
                int tmp = cur.val;
                cur.val = index.val;
                index.val = tmp;
            }
            cur = cur.next;
        }

        head.val = index.val;
        index.val = val;

        return index;
    }
}
