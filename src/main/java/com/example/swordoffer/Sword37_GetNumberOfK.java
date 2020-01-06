package com.example.swordoffer;

/**
 * @description: 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 * @author: icecrea
 * @create: 2019-05-08 22:42
 **/
public class Sword37_GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k);
        int lastK = getLastK(array, k);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    private int getFirstK(int[] array, int k) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (array[mid] == k) {
                if (mid == 0 || array[mid - 1] != k) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int getLastK(int[] array, int k) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (array[mid] == k) {
                if (mid == array.length - 1 || array[mid + 1] != k) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
