package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author: icecrea
 * @create: 2019-05-09 09:01
 **/
public class Sword40_FindNumberAppearOnce {
    /**
     * //num1,num2分别为长度为1的数组。传出参数
     * //将num1[0],num2[0]设置为返回结果
     * <p>
     * 先全部异或，再按照亦或后某一位不为0，分成两个子数组异或
     * [2,4,3,6,3,2,5,5]
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int sum = 0;
        for (int a : array) {
            sum ^= a;
        }
        int firstBit1 = findFirstBit1(sum);
        //按照某一位是不是1来划分成两个数组(保证只出现一次的两个数在两个数组)
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], firstBit1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public int findFirstBit1(int a) {
        int indexBit = 0;
        while (((a & 1) == 0) && indexBit < 32) {
            a = a >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    public boolean isBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    @Test
    public void test() {
        int[] a = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(a, num1, num2);

    }
}
