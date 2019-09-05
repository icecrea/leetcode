package com.example.swordoffer;

/**
 * @description: 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author: icecrea
 * @create: 2019-04-18 00:42
 **/
public class Sword10_RectCover {

    /**
     * 1 1
     * 2 2
     * 3 3
     * 4 5
     *
     * target = n 分为两步考虑：
     * 1.第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
     * 2.第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int p = 1;
        int q = 2;
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = p + q;
            p = q;
            q = sum;
        }
        return sum;
    }
}
