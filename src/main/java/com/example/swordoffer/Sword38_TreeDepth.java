package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * @author: icecrea
 * @create: 2019-05-09 08:43
 **/
public class Sword38_TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left) + 1;
        int right = TreeDepth(root.right) + 1;
        return Math.max(left, right);
    }


    /**
     * 非递归
     *
     * @param pRoot
     * @return
     */
    public int TreeDepth2(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int depth = 0, count = 0, nextCount = 1;
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
            count++;
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            if (count == nextCount) {
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }

    public int TreeDepth3(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
                if (i == size - 1) {
                    depth++;
                }
            }
        }
        return depth;
    }
}
