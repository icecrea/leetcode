package com.example.leetcode.linkedlist;

import com.example.leetcode.linkedlist.pojo.ListNode;

/**
 * @description: 删除链表重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @author: icecrea
 * @create: 2018-12-25 13:17
 **/
public class LeetCode83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            while(cur.val ==cur.next.val){
                cur.next=cur.next.next;
            }
            cur= cur.next;
        }
        return head;
    }
}
