package com.example.summary.binarytree;

import com.example.codeinterviewguide.cp3_binarytree.Node;
import com.example.leetcode.linkedlist.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @description: 二叉树遍历
 * @auther: icecrea
 * @date: 2019/12/16
 */
public class BinaryTreeTraversal {

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    public List<Integer> preOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                cur = node.right;
            }
        }
        return res;
    }

    public List<Integer> inOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                res.add(node.val);
                cur = node.right;
            }
        }
        return res;
    }


    /**
     * 后序非递归
     *
     * @param root
     * @return
     */
    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
        return res;
    }


    /**
     * 层次遍历
     *
     * @param root
     * @param res
     */
    public void levelTraverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 深度优先遍历 等同先序遍历
     *
     * @param root
     * @param res
     */
    public void depthOrderTraverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


    /**
     * 后序遍历非递归 取巧办法：
     * 前序：根->左->右
     * 后序：左->右->根
     * 那么可以把后序当作：根->右->左，然后再反转一下即可。
     *
     * @param root
     * @return
     */
    ArrayList<Integer> postOrder3(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            //反转
            Collections.reverse(res);
        }
        return res;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(8);
        TreeNode rootLeft = new TreeNode(6);
        TreeNode rootLeftLeft = new TreeNode(5);
        TreeNode rootLeftRight = new TreeNode(7);
        TreeNode rootRight = new TreeNode(21);
        root.right = rootRight;
        root.left = rootLeft;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;


        List<Integer> res = new ArrayList<>();
//        preOrder(root, res); // 8 6 5 7 21

//        inOrder(root, res);

//        preOrder2(root, res);
//        depthOrderTraverse(root, res);
        System.out.println(postOrder3(root));
    }


}
