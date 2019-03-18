package com.example.topinterview.easy.dp;

import org.junit.Test;

/**
 * @description: 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金
 * ，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * 1 2 4 3
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 2 7 11 10 12
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @author: icecrea
 * @create: 2019-03-18 20:04
 **/
public class array57_rob {
    public int rob(int[] nums) {
        //此数组maxToCur指的是 到当前位置的最大值
        int[] maxToCur = new int[nums.length];
        int maxSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 2) {
                maxSoFar = Math.max(maxToCur[i - 2] + nums[i], maxSoFar);
                maxToCur[i] = maxSoFar;
            } else {
                maxToCur[i] = nums[i];
                if (i == 1) {
                    maxToCur[i] = Math.max(nums[0], nums[1]);
                }
                maxSoFar = Math.max(maxToCur[i], maxSoFar);
            }
        }
        return maxSoFar;
    }

    /**
     * 上面方法的maxSoFar可以省略
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //此数组maxToCur指的是 到当前位置的最大值
        int[] maxToCur = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i >= 2) {
                maxToCur[i] = Math.max(maxToCur[i - 2] + nums[i], maxToCur[i - 1]);
            } else {
                maxToCur[i] = nums[i];
                if (i == 1) {
                    maxToCur[i] = Math.max(nums[0], nums[1]);
                }
            }
        }
        return maxToCur[nums.length - 1];
    }


    /**
     * 大神解法 更简化
     *
     * @param num
     * @return
     */
    public int rob4(int[] num) {
        //max monney can get if rob current house
        int rob = 0;
        //max money can get if not rob current house
        int notrob = 0;
        for (int i = 0; i < num.length; i++) {
            //if rob current value, previous house must not be robbed
            int currob = notrob + num[i];
            //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            notrob = Math.max(notrob, rob);
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

    @Test
    public void test() {
        // 1 2 4 4
        int rob = rob(new int[]{1, 2, 3, 1});
        // 2 2 3 4
//        int rob = rob(new int[]{2,1,1,2});
        System.out.println(rob);
    }
}
