package com.example.leetcode.binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

/**
 * @description: 二叉树最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 * 1
 * / \
 * 2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: icecrea
 * @create: 2020-05-03
 **/
public class LeetCode124_BinaryTreeMaxPath {


    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }

    /**
     * 以root为根节点的树的单边路径最大值
     */
    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        max = Math.max(max, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

}
