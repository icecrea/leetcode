package com.example.topinterview.easy.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 帕斯卡三角形
 * 定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * @author: icecrea
 * @create: 2019-03-22 15:51
 **/
public class array67_pascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allrows.add(new ArrayList<>(row));
        }
        return allrows;
    }

    @Test
    public void test() {
        System.out.println(generate(4));
        System.out.println(generate(5));
    }

}
