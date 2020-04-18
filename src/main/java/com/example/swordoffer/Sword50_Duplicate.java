package com.example.swordoffer;

import java.util.HashSet;

/**
 * @description: 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author: icecrea
 * @create: 2019-09-06 00:40
 **/
public class Sword50_Duplicate {

    /**
     * 核心是依据题目条件：所有数字在0到n-1的范围
     * <p>
     * 在java虚拟机规范中，JVM没有用于操作boolean的字节码指令，在编译后用int的数据类型代替boolean，此时boolean占4字节。
     * 而boolean[]数组编译后会被byte[]数组代替，此时的boolean占1字节。
     */
    public boolean duplicate(int arr[], int length, int[] duplication) {
        boolean[] hash = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (hash[arr[i]] == true) {
                duplication[0] = arr[i];
                return true;
            }
            hash[arr[i]] = true;
        }
        return false;
    }


    /**
     * 不需要额外空间
     * 已知大小在0~n-1之间，假如无重复数字，则排序后数字i应该在下标i位置上。
     * 扫描数组，当扫描到下标i，比较该数字m，是否m=i。
     * 如果相同扫描下一个。
     * 如果不同，拿它和第m个数字进行比较：
     * - 如果它和第m个数字相等，则找到了第一个重复数字。
     * - 如果不相同，把第i个数字和第m个数字交换，把m放到属于它的位置。重复这个比较，交换的过程
     *
     * 如 2，3，1，0，2，5，3
     * 第一次交换：1，3，2，0，2，5，3
     * 第二次交换：3，1，2，0，2，5，3
     * 第三次交换：0，1，2，3，2，5，3
     * 第四次发现重复数字2
     */
    public boolean duplicate2(int arr[], int length, int[] duplication) {
        if (arr == null) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    duplication[0] = arr[i];
                    return true;
                }

                //交换
                swap(arr, i, arr[i]);
            }
        }

        return false;
    }


    public void swap(int a[], int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public boolean duplicate3(int numbers[], int length, int[] duplication) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < length; i++) {
            if (!set.add(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
