package com.example.swordoffer;

/**
 * @description: 二叉树的后序遍历列表
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author: icecrea
 * @create: 2019-04-22 07:31
 **/
public class Sword23_VerifySquenceOfBST {

    /**
     * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：
     * T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    public boolean judge(int[] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }
        int i = r;
        //从i-1开始往前，和根节点比较
        while (i > l && sequence[i - 1] > sequence[r]) {
            i--;
        }
        for (int p = l; p < i; p++) {
            if (sequence[p] > sequence[r]) {
                return false;
            }
        }
        return judge(sequence, l, i - 1) && judge(sequence, i, r - 1);
    }


    /**
     * 循环遍历
     * 后序遍历是左右中。左边的小于最后一个元素，右边的大于最后一个元素。
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST2(int[] sequence) {
        int n = sequence.length;
        int i = 0;
        if (n == 0) {
            return false;
        }

        while (--n != 0) {
            while (sequence[i] < sequence[n]) {
                i++;
            }
            while (sequence[i] > sequence[n]) {
                i++;
            }
            if (i < n) {
                return false;
            }
            i = 0;
        }
        return true;
    }

}
