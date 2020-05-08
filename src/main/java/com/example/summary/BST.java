package com.example.summary;

import com.example.leetcode.linkedlist.pojo.ListNode;
import com.example.leetcode.linkedlist.pojo.TreeNode;
import com.example.swordoffer.Sword26_BSTToDoubleLinkedList;
import com.example.swordoffer.Sword62_KthNode;
import com.example.topinterview.easy.tree.array48_isValidBST;
import com.example.topinterview.easy.tree.array51_sortedArrayToBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉搜索树专题
 * - 判断是否二叉搜索树
 * - 有序链表转换二叉搜索树,二叉搜索树转有序链表 TODO
 * - 有序数组转二叉搜索树（高度平衡）
 * - 二叉搜索树的第K小的节点
 * - 1-n为节点能生成的所有BST，1-n为节点能生成的所有BST个数 TODO
 * @auther: icecrea
 * @date: 2020/4/24
 */
public class BST {

    /**
     * @see LeetCode96_UniqueBST 1-n组成的不同bst个数
     * @see LeetCode95_UniqueBST2 1-n组成的不同bst
     * @see array48_isValidBST 验证二叉搜索树
     * @see Sword26_BSTToDoubleLinkedList 二叉搜索树转有序链表
     * @see  有序链表转二叉搜索树
     * @see Sword62_KthNode 二叉搜索树的第K小的节点
     * @see array51_sortedArrayToBST 有序数组转二叉搜索树
     */

    /**
     * 判断二叉搜索树
     */
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    /**
     * 二叉搜索树转有序链表 TODO 验证下
     */
    public TreeNode ConvertBSToLinkedList(TreeNode root) {
        if (root == null) {
            return root;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        inOrder(root, q);
        TreeNode pre = q.poll();
        TreeNode cur;
        root = pre;
        pre.left = null;
        while (!q.isEmpty()) {
            cur = q.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return root;
    }

    /**
     * 二叉搜索树的第K小的节点
     */
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }
        LinkedList<TreeNode> q = new LinkedList();
        inOrder(root, q);
        if (k > q.size()) {
            return null;
        }
        return q.get(k - 1);
    }

    void inOrder(TreeNode root, LinkedList<TreeNode> q) {
        if (root == null) {
            return;
        }
        inOrder(root.left, q);
        q.addLast(root);
        inOrder(root.right, q);
    }

    /**
     * 有序数组转二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        //注意终止条件是大于 不是大于等于
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }


}
