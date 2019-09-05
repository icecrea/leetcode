package com.example.swordoffer;

/**
 * @description: 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author: icecrea
 * @create: 2019-09-06 00:40
 **/
public class Sword48_Duplicate {

    /**
     * 思路： 所有数字都在0到n-1的范围，所以可以构造一个n长度的数组tmp，tmp的下标代表数字，tmp的值代表出现次数
     *
     * @param numbers     an array of integers
     * @param length      the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     *                    Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     *                    这里要特别注意~返回任意重复的一个，赋值duplication[0]
     * @return true if the input is valid, and there are some duplications in the array number , otherwise false
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length == 0) {
            return false;
        }

        int tmp[] = new int[length];
        for (int number : numbers) {
            tmp[number]++;
        }


        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] > 1) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }
}
