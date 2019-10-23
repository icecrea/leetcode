package com.example.swordoffer;

/**
 * @description: 二维数组查找
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author: icecrea
 * @create: 2019-04-17 11:08
 **/
public class Sword01_FindInArray {

    /**
     * 从左下角开始查找 向上数字递减，向右数字递增
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        int i = array.length - 1, j = 0;
        while (j < array[0].length && i >= 0) {
            if (target == array[i][j]) {
                return true;
            } else if (target > array[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }


    /**
     * 每行都是递增 利用二分法查找
     * @param array
     * @param target
     * @return
     */
    public boolean Find2(int[][] array, int target) {

        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;

    }
}
