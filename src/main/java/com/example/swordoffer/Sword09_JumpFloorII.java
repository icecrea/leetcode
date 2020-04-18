package com.example.swordoffer;

/**
 * @description: 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author: icecrea
 * @create: 2019-04-18 00:15
 **/
public class Sword09_JumpFloorII {
    /**
     * 1 1 1
     * 2 2 11/2
     * 3 4 111/21/12/3
     * 4 8 1111/121/211/112/31/13/4/22
     * 5 16 11111/1112/1121/1211/2111/311/131/113/14/41/5/221/122/212/32/23
     * <p>
     * <p>
     * <p>
     * <p>
     * 因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
     * 跳1级，剩下n-1级，则剩下跳法是f(n-1)
     * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
     * 所以f(n)=f(n-1)+f(n-2)+...+f(1)
     * 因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
     * 所以f(n)=2*f(n-1)
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return 1 << (target - 1);
    }
}
