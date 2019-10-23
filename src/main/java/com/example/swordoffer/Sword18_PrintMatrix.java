package com.example.swordoffer;

import java.util.ArrayList;

/**
 * @description:顺时针打印矩阵 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: icecrea
 * @create: 2019-04-18 20:13
 **/
public class Sword18_PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = array.length;
        int col = array[0].length;

        int start = 0;
        while (col > start * 2 && row > start * 2) {
            printMatrixInCircle(array, row, col, start, list);
            ++start;
        }
        return list;
    }

    /**
     * 打印一圈的过程 注意最后一圈可能产生退化，导致只有一行，一列，甚至一个数字。 这时打印一圈就不在需要4步，可能需要3/2/1步。需要分析每一步前提条件
     * 第一步是总需要的
     * 第二部前提：终止行号大于起始行号 反例：如a[3][4] 最后一圈
     * 第三步前提：圈内至少两行两列。即除了终止行号大于起始行号，还要终止列号大于起始列号 反例：如a[4][3]最后一圈
     * 第四步前提：圈内至少三行两列。因此要求终止行号比起始行号至少大2，且终止列号大于起始列号
     */
    void printMatrixInCircle(int[][] a, int row, int col, int start, ArrayList<Integer> list) {
        //终止列号 这一圈能到的最大列号
        int endX = col - 1 - start;
        //终止行号 这一圈能到的最大行号
        int endY = row - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            list.add(a[start][i]);
        }

        //从上往下打印一列 前提：终止行号大于起始行号
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                list.add(a[i][endX]);
            }

            //从右到左打印一行 前提：除了终止行号大于其实行号，还要终止列号大于起始列号
            if (start < endX && start < endY) {
                for (int i = endX - 1; i >= start; --i) {
                    list.add(a[endY][i]);
                }
            }

            //从下到上打印一列 前提：终止行号比起始行号至少大2，且终止列号大于起始列号
            if (start < endX && start < endY - 1) {
                for (int i = endY - 1; i >= start + 1; --i) {
                    list.add(a[i][start]);
                }
            }
        }
    }
}
