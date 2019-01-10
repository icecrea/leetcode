package com.example.leetcode.linkedlist.medium;

import com.example.leetcode.linkedlist.pojo.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深度拷贝。
 * @author: icecrea
 * @create: 2019-01-10 11:19
 **/
public class LeetCode138_CopyListWithRandomPointer {
    /**
     * HashMap which holds old nodes as keys and new nodes as its values.
     */
    HashMap<RandomListNode, RandomListNode> visitedHash =
            new HashMap<RandomListNode, RandomListNode>();

    /**
     * 递归方法
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the label same as old node. (i.e. copy the node)
        RandomListNode node = new RandomListNode(head.label);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }

    /**
     * 非递归方法
     */
    HashMap<RandomListNode, RandomListNode> visited = new HashMap<RandomListNode, RandomListNode>();

    public RandomListNode getClonedNode(RandomListNode node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the dictionary
                return this.visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new RandomListNode(node.label));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode oldNode = head;

        // Creating the new head node.
        RandomListNode newNode = new RandomListNode(oldNode.label);
        this.visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned.
        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

}
