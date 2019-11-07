package com.example.swordoffer;

/**
 * @description: 二叉树下一个节点
 * <p>
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author: icecrea
 * @create: 2019-09-11 12:59
 **/
public class Sword57_GetNext {

    /**
     *         A
     *      B     C
     *    D  E  F  G
     *      H I
     * 思路：
     * （1） 若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点 B ）
     * （2） 若该节点不存在右子树：这时分两种情况：
     * 2.1 该节点为父节点的左子节点，则下一个节点为其父节点（如图节点 D ）
     * 2.2 该节点为父节点的右子节点，则沿着父节点向上遍历，知道找到一个节点的父节点的左子节点为该节点，则该节点的父节点下一个节点（如图节点 I ，沿着父节点一直向上查找找到 B （ B 为其父节点的左子节点），则 B 的父节点 A 为下一个节点）
     *
     * @param node
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        //如果有右子树，则找右子树的最左节点
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        //没右子树，则找第一个当前节点是父节点左孩子的节点
        while (node.next != null) {
            if (node.next.left == node) {
                return node.next;
            }
            node = node.next;
        }
        //退到了根节点仍没找到，则返回null
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

