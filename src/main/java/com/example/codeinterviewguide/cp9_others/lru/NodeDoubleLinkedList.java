package com.example.codeinterviewguide.cp9_others.lru;

/**
 * @description: 双向链表，头head优先级最低，尾tail优先级最高
 * 1.新增节点加在尾部并设置为新尾部 addNode
 * 2.结构中任意节点，都可以分离出并放在链表的尾部 moveNodeToTail
 * 3.移除head节点返回，将head节点设置成下一个 如removeHead
 * @author: icecrea
 * @create: 2019-10-16
 **/
public class NodeDoubleLinkedList<V> {
    private Node<V> head;
    private Node<V> tail;

    public NodeDoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(Node<V> newNode) {
        if (newNode == null) {
            return;
        }
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            //连接新节点
            this.tail.next = newNode;
            newNode.last = this.tail;
            //更新尾节点指针为新节点
            this.tail = newNode;
        }
    }

    public void moveNodeToTail(Node<V> node) {
        if (this.tail == node) {
            return;
        }
        if (this.head == node) {
            this.head = node.next;
            this.head.last = null;
        } else {
            node.last.next = node.next;
            node.next.next = node.last;
        }
        node.last = this.tail;
        node.next = null;
        this.tail.next = node;
        this.tail = node;
    }

    public Node<V> removeHead() {
        if (this.head == null) {
            return null;
        }
        Node<V> res = this.head;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = res.next;
            res.next = null;
            this.head.last = null;
        }
        return res;
    }
}
