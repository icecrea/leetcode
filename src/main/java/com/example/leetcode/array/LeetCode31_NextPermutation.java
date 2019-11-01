package com.example.leetcode.array;

/**
 * @description: 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/
 * @author: icecrea
 * @create: 2019-10-24
 **/
public class LeetCode31_NextPermutation {

    /**
     * 当序列递增时，为最小序列。当序列递减时，为最大序列。
     * 我们需要从后往前，找到第一个满足（后>前，即递增）的情况。此时a[i]<a[i+1],且a[i+1]-a[n-1]为递减序列。
     * 如何排列创建下一个更大数字？我们需要将数字 a[i] 替换为位于其右侧区域的数字中比它更大的数字,注意是最小的比它大的数字
     * 从a[i+1]-a[n-1]中，找到比a[i]大的最小数a[j]，进行交换。此时i处是正确的数字，还需要在右侧进行反转，变更为升序排列。
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //此时a[i]到a[i+1]递增，a[i+1]到a[len-1]递减。需要找到交换节点a[j]，从后往前第一个大于a[i]的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        //反转数组中，从i+1到最后的部分
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
