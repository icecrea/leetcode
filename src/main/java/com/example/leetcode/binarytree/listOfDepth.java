package com.example.leetcode.binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description: 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: icecrea
 * @create: 2020-05-03
 **/
public class listOfDepth {

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList();
        LinkedList<TreeNode> q = new LinkedList();
        q.add(tree);
        while (!q.isEmpty()) {
            int size = q.size();
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                ListNode node = new ListNode(poll.val);
                cur.next = node;
                cur = node;
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
            }
            res.add(dummy.next);
        }

        return res.toArray(new ListNode[res.size()]);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
