package com.example.leetcode.other;

/**
 * @description: 螺旋矩阵2
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: icecrea
 * @create: 2020-05-01
 **/
public class LeetCode059_SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, end = n * n;
        while (num <= end) {
            for (int i = left; i <= right; i++) {
                mat[top][i] = num++; // left to right.
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = num++; // top to bottom.
            }
            right--;
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = num++; // right to left.
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = num++; // bottom to top.
            }
            left++;
        }
        return mat;
    }


}
