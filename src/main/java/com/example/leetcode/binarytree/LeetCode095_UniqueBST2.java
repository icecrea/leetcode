package com.example.leetcode.binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树2
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class LeetCode095_UniqueBST2 {
    /**
     * 选择第i个节点作为根，则左子树将包含元素1至i-1，而右子树将包含元素i + 1至n
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return genTreeList(1, n);
    }

    private List<TreeNode> genTreeList(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = genTreeList(start, i - 1);
            List<TreeNode> rightList = genTreeList(i + 1, end);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
