package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author: icecrea
 * @create: 2019-11-07
 **/
public class Sword66_MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols];
        return dfs(0, 0, rows, cols, flag, threshold);
    }

    private int dfs(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1) {
            return 0;
        }
        flag[i][j] = 1;
        return dfs(i - 1, j, rows, cols, flag, threshold)
                + dfs(i + 1, j, rows, cols, flag, threshold)
                + dfs(i, j - 1, rows, cols, flag, threshold)
                + dfs(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }

    @Test
    public void test() {
        System.out.println(movingCount(18, 5, 5));
    }
}
