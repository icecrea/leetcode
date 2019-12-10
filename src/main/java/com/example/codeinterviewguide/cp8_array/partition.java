package com.example.codeinterviewguide.cp8_array;

import org.junit.Test;

/**
 * @description: 数组的partition调整
 * @author: icecrea
 * @create: 2019-12-10
 **/
public class partition {
    /**
     * 题目一
     * 给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复部分且升序，而不用保证右部分是否有序。
     *
     * 例如：arr=[1,2,2,2,3,3,4,5,6,6,7,7,8,8,9,9]，调整之后arr=[1,2,3,4,5,6,7,8,9…]。
     *
     * 要求：
     * 时间复杂度O(N),额外空间复杂度O(1)
     *
     * 变量u: 数组在0..u上都是无重复且升序，u为该区域最后的位置
     * 变量i: 数组在u+1...u上不保证无重复和升序，i为该区域最后的位置
     * i向后移动，因为数组有序，如果a[i]!=a[u],则a[i]可以加入到u区域中，交换a[u++],a[i]
     */
    public void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int u = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[u]) {
                swap(arr, ++u, i);
            }
        }
    }

    /**
     * 题目二：
     * 给定一个数组arr，其中只可能含有0、1、2三个值，请实现arr的排序。
     * 另外一种问法：有一个数组，其中只有红球、篮球和黄球，请实现红球全放在数组的左边，篮球放在中间，黄球放在右边。
     * 另外一种问法：有一个数组，再给定一个值K，请实现比K小的数都放在数组的左边，等于K的值都放在数组的中间，比K大的数都放在数组的右边。
     *
     * 分为三个区域，left指向左区最右位置，index指向中区最右位置，right指向右区最左位置
     * 通过index遍历，含义在left+1...index上都是1
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = -1;
        int index = 0;
        int right = arr.length;
        while (index < right) {
            if (arr[index] == 0) {
                swap(arr, ++left, index++);
            } else if (arr[index] == 2) {
                swap(arr, index, --right);
            } else {
                index++;
            }
        }
    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    @Test
    public void test() {
        int[] ints = {1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 9, 9};
        leftUnique(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

}
