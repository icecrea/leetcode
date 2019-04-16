package com.example.weeklycontest.weeklycontest132;

import org.junit.Test;

/**
 * @description: 节点与其祖先的最大差值
 * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * 每个节点的值介于 0 到 100000 之间。
 * @author: icecrea
 * @create: 2019-04-16 20:33
 **/
public class MaximumDiffBetweenNodeAncestor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public int maxAncestorDiff(TreeNode root) {
//        return dfs(root, root.val, root.val);
//    }
//
//    public int dfs(TreeNode root, int mn, int mx) {
//        if (root == null) {
//            return mx - mn;
//        }
//        mx = Math.max(mx, root.val);
//        mn = Math.min(mn, root.val);
//        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
//    }


    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    /**
     * 对于每个node，都计算一下它所在路径上的最大值和最小值和它的val的差值的绝对值，
     * @param n
     * @param max
     * @param min
     * @return
     */
    private int dfs(TreeNode n, int max, int min) {
        if (n == null) {
            return 0;
        }
        max = Math.max(n.val, max);
        min = Math.min(n.val, min);
        int l = dfs(n.left, max, min);
        int r = dfs(n.right, max, min);
        // compare all super/sub differences to get result.
        return Math.max(max - min, Math.max(l, r));
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode1.left= treeNode2;
        root.left= treeNode1;
        TreeNode treeNode = new TreeNode(10);
        root.right=treeNode;
        maxAncestorDiff(root);
    }
}
