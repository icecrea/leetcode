package com.example.swordoffer;

/**
 * @description: 求1+2+3+...+n
 * <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author: icecrea
 * @create: 2019-09-05 00:11
 **/
public class Sword46_Sum {


    /**
     * 利用短路与的特性，弥补无法使用if else，实现递归的终止条件（n=0的计算）
     * <p>
     * 当n=0时候，不执行n += Sum_Solution(n - 1)，直接返回0
     * 当n>0时，递归执行Sum_Solution
     *
     * @param n
     * @return
     */
    int Sum_Solution(int n) {
        boolean flag = (n > 0) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
}
