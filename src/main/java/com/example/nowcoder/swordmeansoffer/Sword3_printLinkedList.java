package com.example.nowcoder.swordmeansoffer;

import com.example.leetcode.linkedlist.pojo.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: 打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @author: icecrea
 * @create: 2019-04-17 11:46
 **/
public class Sword3_printLinkedList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode= listNode.next;
        }
        ArrayList<Integer> list = new ArrayList();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHeadRecur(ListNode listNode) {
        return recur(listNode);
    }

    public ArrayList recur(ListNode node){
        if(node == null){
            return new ArrayList<Integer>();
        }
        ArrayList recur = recur(node.next);
        recur.add(node.val);
        return recur;
    }
}
