// 52. N-Queens II

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

// Example 1:
// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:
// Input: n = 1
// Output: 1

//CODE:

class Solution {
    int count = 0;
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    public int totalNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        backtrack(0, n);
        return count;
    }
    void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            backtrack(row + 1, n);
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
