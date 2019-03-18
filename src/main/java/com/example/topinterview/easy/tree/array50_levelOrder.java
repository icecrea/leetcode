package com.example.topinterview.easy.tree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author: icecrea
 * @create: 2019-03-18 12:04
 **/
public class array50_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if (root == null) {
            return wrapList;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    /**
     * 用dfs思路 解决Bfs问题 list的size对应为二叉树层数
     *
     * @param res
     * @param root
     * @param height
     */
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }
}
