package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 二叉搜索树的第K个节点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class Sword62_KthNode {
    /**
     * 计数器
     */
    int index = 0;

    /**
     * 如果没有if(node != null)这句话  那么那个root就是返回给上一级的父结点的，而不是递归结束的条件了,有了这句话过后，一旦返回了root，
     * 那么node就不会为空了，就一直一层层的递归出去到结束了。举第一个例子{8,6,5,7,},1 答案应该是5，
     * 如果不加的时候，开始，root=8，node=kth（6,1），继续root=6，node=kth（5,1）root =5 返回null，
     * 这时向下执行index=k=1了，返回 5给root=6递归的时候的node，这时回到root=8了，
     * 往后面调右孩子的时候为空而把5给覆盖了。现在就为空了，有了这句话后虽然为空，但不把null返回，而是继续返回5
     *
     * @param root
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode root, int k) {
        //中序遍历寻找第k个
        if (root != null) {
            TreeNode node = KthNode(root.left, k);
            if (node != null) {
                return node;
            }
            index++;
            if (index == k) {
                return root;
            }
            node = KthNode(root.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }


    TreeNode KthNode2(TreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = root;
        do {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                count++;
                if (count == k) {
                    return node;
                }
                node = node.right;
            }
        } while (node != null || !stack.isEmpty());
        return null;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(8);
        TreeNode rootLeft = new TreeNode(6);
        TreeNode rootLeftLeft = new TreeNode(5);
        TreeNode rootLeftRight = new TreeNode(7);
        root.left = rootLeft;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;

        TreeNode treeNode = KthNode(root, 1);
        System.out.println(treeNode);
    }

}
