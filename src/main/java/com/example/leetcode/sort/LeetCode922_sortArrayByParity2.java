package com.example.leetcode.sort;

/**
 * @description: 按奇偶排序数组2
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * @author: icecrea
 * @create: 2019-04-01 21:41
 **/
public class LeetCode922_sortArrayByParity2 {

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] a = new int[A.length];
        int p = 0, q = 1;
        int i = 0;
        while (i < len) {
            if (isEven(A[i])) {
                a[p] = A[i++];
                p = p + 2;
            } else {
                a[q] = A[i++];
                q = q + 2;
            }
        }
        return a;
    }

    private boolean isEven(int x) {
        return (x & 1) == 0;
    }

    /**
     * 从左往后 每次大圈遍历交换 奇书位非计数与偶数位非偶数值
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        int i = 0, j = 1, n = A.length;
        while (i < n && j < n) {
            while (i < n && (A[i] & 1) == 0) {
                i += 2;
            }
            while (j < n && (A[j] & 1) == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
