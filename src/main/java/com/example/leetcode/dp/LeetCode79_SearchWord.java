package com.example.leetcode.dp;

import com.example.swordoffer.Sword65_MatrixPath;
import org.junit.Test;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 相关题目：
 *
 * @see Sword65_MatrixPath
 */
public class LeetCode79_SearchWord {

    public boolean exist(char[][] board, String word) {
        boolean flag[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dp(board, word, i, j, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dp(char[][] board, String word, int i, int j, boolean flag[][], int k) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || flag[i][j] == true || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        flag[i][j] = true;
        if (dp(board, word, i - 1, j, flag, k + 1) ||
                dp(board, word, i + 1, j, flag, k + 1) ||
                dp(board, word, i, j - 1, flag, k + 1) ||
                dp(board, word, i, j + 1, flag, k + 1)) {
            return true;
        }
        flag[i][j] = false;
        return false;
    }

    @Test
    public void test() {
        char[][] matrix = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(exist(matrix, "ABCCED"));
        System.out.println(exist(matrix, "SEE"));
        System.out.println(exist(matrix, "ABCB"));
    }

}
