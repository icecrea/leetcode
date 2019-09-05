package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 连续子数组最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author: icecrea
 * @create: 2019-05-08 15:48
 **/
public class Sword29_FindGreatestSumOfSubArray {


    /**
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        //到当前为止的最大数（包括当前数）
        int maxToCur = 0;
        //最大总数
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (maxToCur <= 0) {
                maxToCur = array[i];
            } else {
                maxToCur += array[i];
            }
            max = Math.max(max, maxToCur);
        }
        return max;
    }

    @Test
    public void test() {
//        int i = FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2});
        int i = FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(i);
    }
}
