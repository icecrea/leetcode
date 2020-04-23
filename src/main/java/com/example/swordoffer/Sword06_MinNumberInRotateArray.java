package com.example.swordoffer;

import org.junit.Test;

/**
 * @description: 旋转数组的最小数字 TODO
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author: icecrea
 * @create: 2019-04-17 13:29
 **/
public class Sword06_MinNumberInRotateArray {
    /**
     * 思路二分查找
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) { //这一步可以转化成下面的方式， high = mid;
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

    public int minNumberInRotateArray2(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[low];
    }

    @Test
    public void test() {
        System.out.println(minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minNumberInRotateArray(new int[]{3, 4, 5, 5, 5}));
        System.out.println(minNumberInRotateArray(new int[]{3, 4, 2, 2, 2}));
        System.out.println(minNumberInRotateArray(new int[]{3, 1, 2}));
        System.out.println(minNumberInRotateArray(new int[]{3, 2, 2}));
        System.out.println(minNumberInRotateArray2(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minNumberInRotateArray2(new int[]{3, 4, 5, 5, 5}));
        System.out.println(minNumberInRotateArray2(new int[]{3, 4, 2, 2, 2}));
        System.out.println(minNumberInRotateArray2(new int[]{3, 2, 2}));
    }

}
