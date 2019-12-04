package com.example.topinterview.easy.tree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * @author: icecrea
 * @create: 2019-03-18 10:38
 **/
public class array47_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 利用队列
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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
}
