package com.example.codeinterviewguide.cp3_binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

/**
 * @description: 统计完全二叉树节点数
 * @author: icecrea
 * @create: 2019-10-20
 **/
public class CompleteTreeNodeNumber {

    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
