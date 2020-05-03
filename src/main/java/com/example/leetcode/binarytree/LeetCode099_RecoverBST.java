package com.example.leetcode.binarytree;

import com.example.leetcode.linkedlist.pojo.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 * 3
 * / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: icecrea
 * @create: 2020-05-01
 **/
public class LeetCode099_RecoverBST {

//    public void recoverTree(TreeNode root) {
//        ArrayList<TreeNode> list = new ArrayList<>();
//        inOrder(list, root);
//        int[] swapped = findTwoSwapped(list);
//        recover(root, 2, swapped[0], swapped[1]);
//    }
//
//    public int[] findTwoSwapped(List<Integer> nums) {
//        int n = nums.size();
//        int x = -1, y = -1;
//        for (int i = 0; i < n - 1; ++i) {
//            if (nums.get(i + 1) < nums.get(i)) {
//                y = nums.get(i + 1);
//                // first swap occurence
//                if (x == -1) x = nums.get(i);
//                    // second swap occurence
//                else break;
//            }
//        }
//        return new int[]{x, y};
//    }
//
//    public void recover(TreeNode r, int count, int x, int y) {
//        if (r != null) {
//            if (r.val == x || r.val == y) {
//                r.val = r.val == x ? y : x;
//                if (--count == 0) return;
//            }
//            recover(r.left, count, x, y);
//            recover(r.right, count, x, y);
//        }
//    }
//
//    public void recoverTree2(TreeNode root) {
//        ArrayList<TreeNode> list = new ArrayList<>();
//        inOrder(list, root);
//        for (int i = 1; i < list.size() - 1; i++) {
//            if (list.get(i).val < list.get(i + 1).val) {
//
//            }
//        }
//    }
//
//
//    void inOrder(List<TreeNode> list, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        inOrder(list, root.left);
//        list.add(root);
//        inOrder(list, root.right);
//    }
//
//    TreeNode firstNode = null;
//    TreeNode secondNode = null;
//    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

//    public void recoverTree(TreeNode root) {
//
//        in_order(root);
//        int tmp = firstNode.val;
//        firstNode.val = secondNode.val;
//        secondNode.val = tmp;
//    }
//
//    private void in_order(TreeNode root) {
//        if (root == null) return;
//        in_order(root.left);
//        if (firstNode == null && preNode.val > root.val) firstNode = preNode;
//        if (firstNode != null && preNode.val > root.val) secondNode = root;
//        preNode = root;
//        in_order(root.right);
//    }


}
