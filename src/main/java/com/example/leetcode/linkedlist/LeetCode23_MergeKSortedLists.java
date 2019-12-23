package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: 合并k个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * @author: icecrea
 * @create: 2019-01-17 20:45
 **/
public class LeetCode23_MergeKSortedLists {

    /**
     * 如果不限制空间复杂度，可以放到数组中排序，再拿出
     * 时间复杂度O(NlogN) = 遍历所有值 O(N) + 稳定排序算法O(NlongN) + 遍历创建新链表O(N)
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        List<ListNode> allList = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                allList.add(node);
                node = node.next;
            }
        }
        allList.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : allList) {
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    /**
     * 如果不限制空间复杂度，也可以使用优先级队列
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        //空集合初始化优先级队列会抛出异常， 此处需要先判空
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }

    /**
     * 分治法：递归拆分链表变成单独链表，再两两合并 思路类似链表的归并排序
     * 时间复杂度：O(Nlogk)，其中k 链表的数目
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public ListNode partion(ListNode[] lists, int start, int end) {
        //终止条件
        if (start == end) {
            return lists[start];
        }
        int mid = start + ((end - start) >> 1);
        ListNode l1 = partion(lists, start, mid);
        ListNode l2 = partion(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


}
