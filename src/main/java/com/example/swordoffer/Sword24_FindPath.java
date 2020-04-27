package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树中和为某一值的路径 TODO
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @author: icecrea
 * @create: 2019-04-22 08:14
 **/
public class Sword24_FindPath {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }


    public List<List<Integer>> FindPath2(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(root, target, list, res);
        return res;
    }

    public void backTrack(TreeNode root, int target, List<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(list));
        }

        list.add(root.left.val);
        backTrack(root.left, target - root.val, list, res);
        list.remove(list.size() - 1);

        list.add(root.right.val);
        backTrack(root.right, target - root.val, list, res);
        list.remove(list.size() - 1);
    }
}
