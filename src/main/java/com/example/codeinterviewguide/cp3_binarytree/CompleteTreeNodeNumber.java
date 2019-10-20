package com.example.codeinterviewguide.cp3_binarytree;

/**
 * @description: 统计完全二叉树节点数
 * @author: icecrea
 * @create: 2019-10-20
 **/
public class CompleteTreeNodeNumber {

    public int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * 返回以node为头节点的完全二叉树节点数是多少
     *
     * @param node
     * @param l    node所在层数（head为1层，从上往下1234...n）
     * @param h    这个数的层数，不变
     * @return
     */
    public int bs(Node node, int l, int h) {
        //遍历到最下层唯一的节点
        if (l == h) {
            return 1;
        }
        //如果右子树的最左节点所在层数和树高相同，说明左子树是满二叉树  左子树+根节点总数 = 2^(h-l) -1 + 1
        if (mostLeftLevel(node.right, l + 1) == h) {
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            //如果右子树的最左节点所在层数和树高不同，说明右子树是满二叉树  右子树+根节点总数 = 2^(h-1-l) -1 + 1
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    /**
     * 树的最左节点最大能到哪层
     *
     * @param node
     * @param level
     * @return
     */
    int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
