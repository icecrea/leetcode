package com.example.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: n皇后问题
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * （国际象棋中的皇后，可以横向、纵向、斜向移动。如何在一个8X8的棋盘上放置8个皇后，使得任意两个皇后都不在同一条横线、竖线、斜线方向上）
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例:
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auther: icecrea
 * @date: 2020/4/20
 */
public class LeetCode051_NQueens {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append('.');
        }
        for (int i = 0; i < n; ++i) {
            board.add(sb.toString());
        }

        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int row, int n, List<String> board) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (!isValid(row, col, board, n)) {
                continue;
            }
            setChar(row, col, 'Q', board);
            backtrack(row + 1, n, board);
            setChar(row, col, '.', board);
        }
    }

    private boolean isValid(int row, int col, List<String> board, int n) {
        //该列上不重复
        for (int i = 0; i < row; ++i) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        //左上斜线上不重复
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        //右上斜线上不重复
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void setChar(int row, int col, char c, List<String> board) {
        StringBuilder sb = new StringBuilder(board.get(row));
        sb.setCharAt(col, c);
        board.set(row, sb.toString());
    }
}
