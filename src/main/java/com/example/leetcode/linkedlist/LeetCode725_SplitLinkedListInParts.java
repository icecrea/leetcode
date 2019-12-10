package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description:分隔链表 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 * <p>
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 * <p>
 * <p>
 * 提示:
 * <p>
 * root 的长度范围： [0, 1000].
 * 输入的每个节点的大小范围：[0, 999].
 * k 的取值范围： [1, 50].
 * @author: icecrea
 * @create: 2019-01-02 19:25
 **/
public class LeetCode725_SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (cur != null) {
                    cur = cur.next;
                }
            }

            //当前段的尾指针置空 转移下一个指针
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }

    /**
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts2(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int count = 0;
        ListNode cur = root;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        cur = root;
        int size = count / k, extra = count % k;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            //Find the tail
            for (int j = 0; j < size + (extra > 0 ? 1 : 0) - 1; j++) {
                cur = cur.next;
            }

            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;

            extra--;
        }
        return res;
    }

}
