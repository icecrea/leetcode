package com.example.swordoffer;

/**
 * @description: 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author: icecrea
 * @create: 2019-04-22 08:32
 **/
public class Sword25_Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode cur = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (cur != null) {
            RandomListNode cloneNode = new RandomListNode(cur.label);
            RandomListNode nextNode = cur.next;

            cur.next = cloneNode;
            cloneNode.next = nextNode;
            cur = nextNode;
        }

        cur = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next; (注意是的随机节点=老随机节点下一个)
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur != null) {
            RandomListNode cloneNode = cur.next;
            cur.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            cur = cur.next;
        }

        return pCloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
