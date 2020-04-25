package com.example.leetcode.binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;
import org.junit.Test;

/**
 * 二叉树最近公共父节点
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class LeetCode236_LowestCommonAncestorOfBinaryTree {

    /**
     * 1。如果其中一个节点是根节点，返回根节点为最近公共父节点
     * 2。都不是根节点，分别递归左子树，右子树，看哪个子树存在pq的最近公共父节点
     * 3。如果都不存在，说明pq分别在两个子树上，一边一个，返回根节点
     * 4。如果其中一个存在，返回结果
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //两个节点分别在root的左右分支，返回根节点为最近公共节点
        if (left != null && right != null) {
            return root;
        }
        return right == null ? left : right;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        TreeNode right = new TreeNode(1);
        root.left = null;
        root.right = right;
    }
}
