// N QUEEN 

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//  You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
//  both indicate a queen and an empty space, respectively.

// CODE:

import java.util.*;

class Solution {
    List<List<String>> result = new ArrayList<>();
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        backtrack(0, n, board);
        return result;
    }
    void backtrack(int row, int n, char[][] board) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            // Move to next row
            backtrack(row + 1, n, board);
            // Backtracking: remove queen
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}

 