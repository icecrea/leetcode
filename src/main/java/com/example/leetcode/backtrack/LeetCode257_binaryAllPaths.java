package com.example.leetcode.backtrack;

import com.example.leetcode.linkedlist.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/20
 */
public class LeetCode257_binaryAllPaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        String track = "";
        backTrack(root, res, track);
        return res;
    }

    void backTrack(TreeNode node, List<String> res, String track) {
        if (node.right == null && node.left == null) {
            track += node.val;
            res.add(track);
            return;
        }
//        track += node.val + "->";
        if (node.left != null) {
            backTrack(node.left, res, track + node.val + "->");
        }
        if (node.right != null) {
            backTrack(node.right, res, track + node.val + "->");
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(8);
        TreeNode rootLeft = new TreeNode(6);
        TreeNode rootLeftLeft = new TreeNode(5);
        TreeNode rootLeftRight = new TreeNode(7);
        root.left = rootLeft;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;

        System.out.println(binaryTreePaths(root));
    }
}
