package com.example.swordoffer;

import com.example.leetcode.linkedlist.pojo.TreeNode;


/**
 * @description: 树的子结构 TODO
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author: icecrea
 * @create: 2019-04-18 19:25
 **/
public class Sword17_HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 == null || root1 == null) {
            return false;
        }
        //如果找到了对应Tree2的根节点的点
        if (root1.val == root2.val) {
            //以这个根节点为为起点判断是否包含Tree2
            result = isSameTree(root1, root2);
        }
        //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }

        //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        //返回结果
        return result;
    }

    /**
     * 比较两颗树是否完全相同
     */
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        // 都为空的话，显然相同
        if (root1 == null && root2 == null) {
            return true;
        }
        // 一个为空，一个非空，显然不同
        if (root1 == null || root2 == null) {
            return false;
        }
        // 两个都非空，但 val 不一样也不行
        if (root1.val != root2.val) {
            return false;
        }
        // root1 和 root2 该比的都比完了
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
