// UNIQUE PATHS 111


// you are given an m x n integer array grid where grid[i][j] could be:

// 1 representing the starting square. There is exactly one starting square.
// 2 representing the ending square. There is exactly one ending square.
// 0 representing empty squares we can walk over.
// -1 representing obstacles that we cannot walk over.
// Return the number of 4-directional walks from the starting square to the ending square,
//  that walk over every non-obstacle square exactly once.

 
// Example 1:
// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
// Output: 2
// Explanation: We have the following two paths: 
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
// 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
// Example 2:

// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
// Output: 4
// Explanation: We have the following four paths: 
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
// 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
// 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
// 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

// CODE:
class Solution {
	public int backtrack(
		int[][] grid, int row, int col, int[][] visit
	) {
		int m = grid.length;
		int n = grid[0].length;

		if (row < 0 || col < 0 || row >= m || col >= n)
			return 0;

		if (grid[row][col] == -1)
			return 0;

		if (grid[row][col] == 2) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == -1 || grid[i][j] == 2)
						continue;
					if (visit[i][j] != 1)
						return 0;
				}
			}
			return 1;
		}

		if (visit[row][col] == 1)
			return 0;

		visit[row][col] = 1;

		int leftCnt = backtrack(grid, row, col - 1, visit);
		int rightCnt = backtrack(grid, row, col + 1, visit);
		int upCnt = backtrack(grid, row - 1, col, visit);
		int downCnt = backtrack(grid, row + 1, col, visit);

		visit[row][col] = 0;

		return leftCnt + rightCnt + upCnt + downCnt;
	}

	public int uniquePathsIII(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] visit = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					return backtrack(grid, i, j, visit);
			}
		}

		return 0;
	}
}