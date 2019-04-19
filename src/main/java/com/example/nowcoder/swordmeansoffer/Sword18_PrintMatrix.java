package com.example.nowcoder.swordmeansoffer;

import java.util.ArrayList;

/**
 * @description:顺时针打印矩阵 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: icecrea
 * @create: 2019-04-18 20:13
 **/
public class Sword18_PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (array.length == 0) {
            return result;
        }
        int n = array.length, m = array[0].length;
        if (m == 0) {
            return result;
        }
        int layers = (Math.min(n, m) - 1) / 2 + 1;
        for (int i = 0; i < layers; i++) {
            //左至右
            for (int k = i; k < m - i; k++) {
                result.add(array[i][k]);
            }
            //右上至右下
            for (int j = i + 1; j < n - i; j++) {
                result.add(array[j][m - i - 1]);
            }
            //右至左
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) {
                result.add(array[n - i - 1][k]);
            }
            //左下至左上
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) {
                result.add(array[j][i]);
            }
        }
        return result;
    }


    /**
     * 顺着走，即向右->向下->向左->向上，一共要走（长*宽）步。遇到边界就改变方向，当向上碰到顶的时候，四个边界都缩小。思路简单，一个循环即可
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix2(int[][] matrix) {
        int xLength, yLength;
        if ((yLength = matrix.length) == 0 || (xLength = matrix[0].length) == 0) {
            return null;
        }
        int length = xLength * yLength;
        int x = 0, y = 0;
        int left = 0, right = xLength - 1, ceil = 0, floor = yLength - 1;
        int dir = 0;
        ArrayList<Integer> arr = new ArrayList<>(length);
        while (length > 0) {
            arr.add(matrix[y][x]);
            switch (dir) {
                case 0:
                    if (x == right) {
                        ceil++;
                        y++;
                        dir = 1;
                    } else {
                        x++;
                    }
                    break;
                case 1:
                    if (y == floor) {
                        right--;
                        x--;
                        dir = 2;
                    } else {
                        y++;
                    }
                    break;
                case 2:
                    if (x == left) {
                        floor--;
                        y--;
                        dir = 3;
                    } else {
                        x--;
                    }
                    break;
                case 3:
                    if (y == ceil) {
                        left++;
                        x++;
                        dir = 0;
                    } else {
                        y--;
                    }
                    break;
                default:
                    break;
            }
            length--;
        }
        return arr;
    }
}
