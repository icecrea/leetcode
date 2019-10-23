package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author: icecrea
 * @create: 2019-04-19 13:27
 **/
public class Sword21_PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }

    /**
     * 进阶版，从上往下打印二叉树，要求每层打印出一个换行符，即打印出每层的信息
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottomWithLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        if (root == null) {
            return listAll;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            listAll.add(list);
        }

        return listAll;
    }

}
