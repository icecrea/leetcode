package com.example.codeinterviewguide.cp2_linkedlist;

import com.example.leetcode.linkedlist.pojo.RandomListNode;

import java.util.HashMap;

/**
 * @description: 复制含有随机指针节点的链表
 * @author: icecrea
 * @create: 2019-09-30
 **/
public class p09_CopyListWithRandom {
    public static RandomListNode copyListWithRand1(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static RandomListNode copyListWithRand2(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        RandomListNode next;
        // copy node and link to every node
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        RandomListNode curCopy = null;
        // set copy node rand
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        RandomListNode res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

}
