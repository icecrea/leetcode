package com.example.nowcoder.swordmeansoffer;

import java.util.ArrayList;

/**
 * @description: 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @author: icecrea
 * @create: 2019-05-09 13:24
 **/
public class Sword41_FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }

        }
        return list;
    }
}
