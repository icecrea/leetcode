package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: 之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @author: icecrea
 * @create: 2019-09-11 13:01
 **/
public class Sword59_PrintZigZag {

    /**
     * 类似题目： 剑指offer21 从上往下打印二叉树
     *
     * @param pRoot
     * @return
     * @see Sword22_PrintFromTopToBottom
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<>();

        ArrayList<ArrayList<Integer>> allList = new ArrayList<>();

        while (!s1.empty() || !s2.empty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if ((layer & 1) == 1) {
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        list.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
            } else {
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        list.add(node.val);
                        //注意此时的顺序是反过来的，先右节点后左节点入栈
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
            }
            if (!list.isEmpty()) {
                allList.add(list);
                layer++;
            }
        }
        return allList;
    }

}
