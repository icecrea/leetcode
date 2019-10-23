package com.example.codeinterviewguide.cp3_binarytree;

/**
 * @description: 找到二叉树中的最大搜索二叉子树
 * @author: icecrea
 * @create: 2019-10-20
 **/
public class BiggestSubBSTInTree {

    public class ReturnType {
        /**
         * 最大二叉搜索树的头节点
         */
        public Node maxBSTHead;

        /**
         * 最大二叉搜索树的大小
         */
        public int maxBSTSize;
        public int min;
        public int max;

        public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public Node getMaxBST(Node head) {
        return process(head).maxBSTHead;
    }

    /**
     * 存在情况
     * 1.以n为头节点的子树中，最大搜索二叉子树是n左子树中的最大搜索二叉子树
     * 2.以n为头节点的子树中，最大搜索二叉子树是n右子树中的最大搜索二叉子树
     * 3.如果n左子树上最大搜索二叉子树是全体，n右子树最大二叉搜索子树是全体，且x的值大于左子树所有节点最大值，但小于右子树所有节点最小值。则n为头节点的子树中，最大二叉所搜子树是n全体。
     *
     * 由上知，我们需要的信息：最大搜索二叉子树的头节点，最大搜索二叉子树的大小，因为比较第3种情况，还需要左子树的最大值和右子树的最小值
     *
     * @param head
     * @return
     */
    public ReturnType process(Node head) {
        //如果是空树 最小值系统最大 最大值系统最小
        if (head == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        ReturnType lData = process(head.left);
        ReturnType rData = process(head.right);
        //以head为头节点的子树的最小值为：左树最小，右树最小和head三者中最小的
        int min = Math.min(head.value, Math.min(lData.min, rData.min));
        //以head为头节点的子树的最大值为：左树最大，右树最大和head三者中最大的
        int max = Math.max(head.value, Math.min(lData.max, rData.max));

        //只考虑1，2情况下，以head为头节点的子树的最大搜索二叉树大小和头节点指针
        int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);
        Node maxBSTHead = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;


        if (lData.maxBSTHead == head.left && rData.maxBSTHead == head.right
                && head.value > lData.max && head.value < rData.min) {
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
            maxBSTHead = head;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

}
