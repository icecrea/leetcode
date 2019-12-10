package com.example.topinterview.easy.tree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 *
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @author: icecrea
 * @create: 2019-03-18 12:04
 **/
public class array50_levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return all;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < len; i++) {
                TreeNode poll = q.poll();
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                list.add(poll.val);
            }
            all.add(list);
        }
        return all;
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
