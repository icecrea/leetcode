package com.example.leetcode.dp;

import org.junit.Test;

/**
 * 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 * ['1','0','1','0','0'],
 * ['1','0','1','1','1'],
 * ['1','1','1','1','1'],
 * ['1','0','0','1','0']
 * ]
 * 输出: 6
 */
public class LeetCode85_MaximalRectangle {
    /**
     * 只包含1的矩形，需要连续的1
     * 构造width[][]数组，width[i][j]代表从左往右到i,j为止，连续的1的个数。 如下图
     * 1 0 1 0 0
     * 1 0 1 2 3
     * 1 2 3 4 5
     * 1 0 0 1 0
     * 以每个点作为矩阵的右下角，找到以其为右下角的最大矩阵。遍历找到最大矩阵的值
     *
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //保存以当前数字结尾的连续 1 的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        //遍历每一行
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //更新 width
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //记录当前列最小的数字，即为矩阵的宽
                int minWidth = width[row][col];
                //向上扩展行
                for (int upRow = row; upRow >= 0; upRow--) {
                    //矩阵高度
                    int height = row - upRow + 1;
                    //找当前列最小的数作为矩阵的宽
                    minWidth = Math.min(minWidth, width[upRow][col]);
                    //更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }



    @Test
    public void test() {
        char[][] c = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(c));
    }

}
