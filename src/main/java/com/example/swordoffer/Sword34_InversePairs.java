package com.example.swordoffer;

/**
 * @description: 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * <p>
 * 对于%50的数据,size<=10^4
 * <p>
 * 对于%75的数据,size<=10^5
 * <p>
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 * @author: icecrea
 * @create: 2019-05-08 20:54
 **/
public class Sword34_InversePairs {

    public int InversePairs(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return InversePairs(array, copy, 0, array.length - 1);
    }

    public int InversePairs(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        int len = (end - start) / 2;
        int left = InversePairs(copy, array, start, start + len) % 1000000007;
        int right = InversePairs(copy, array, start + len + 1, end) % 1000000007;

        int i = start + len;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + len + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - len;
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[indexCopy--] = array[j--];
            }
        }
        for (; i >= start; --i) {
            copy[indexCopy--] = array[i];
        }
        for (; j >= start + len + 1; --j) {
            copy[indexCopy--] = array[j];
        }
        return (left + right + count) % 1000000007;
    }
}
