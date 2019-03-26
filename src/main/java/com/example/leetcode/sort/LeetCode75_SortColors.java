package com.example.leetcode.sort;

import org.junit.Test;

/**
 * @description: 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @author: icecrea
 * @create: 2019-03-25 09:39
 **/
public class LeetCode75_SortColors {

    public void sortColors(int[] nums) {
        //[0,0,1,1,2,2]
        int[] a = new int[3];
        for (int i : nums) {
            a[i]++;
        }
        int p = 0;
        for (int i = 0; i < a.length; i++) {
            int len = a[i];
            for (int j = p; j < p + len; j++) {
                nums[j] = i;
            }
            p += len;
        }
    }

    public void sortColors2(int[] nums) {
        int second = nums.length - 1, zero = 0;
        for (int i = 0; i <= second; i++) {
            while (nums[i] == 2 && i < second) {
                swap(nums, i, second--);
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums, i, zero++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 比上面方法又减少了比较操作
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[red];
                nums[red] = temp;

                red++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = temp;

                i--;
                blue--;
            }
        }
    }

    @Test
    public void test() {
        sortColors3(new int[]{2, 0, 2, 1, 1, 0});
    }

}
