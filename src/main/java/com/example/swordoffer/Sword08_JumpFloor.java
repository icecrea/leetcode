package com.example.swordoffer;

/**
 * @description: 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author: icecrea
 * @create: 2019-04-18 00:10
 **/
public class Sword08_JumpFloor {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloor2(int target) {
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
