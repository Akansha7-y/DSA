// ESCAPE A LARGE MAZE 
// RAT IN MAZE 

// There is a 1 million by 1 million grid on an XY-plane, and the coordinates of each grid square are (x, y).

// We start at the source = [sx, sy] square and want to reach the target = [tx, ty] square. 
// There is also an array of blocked squares, where each blocked[i] = [xi, yi] represents a blocked square with coordinates (xi, yi).

// Each move, we can walk one square north, east, south, or west if the square is not in the array of blocked squares.
//  We are also not allowed to walk outside of the grid.

// Return true if and only if it is possible to reach the target square from the source square through a sequence of valid moves.

// Example 1:

// Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
// Output: false
// Explanation: The target square is inaccessible starting from the source square because we cannot move.
// We cannot move north or east because those squares are blocked.
// We cannot move south or west because we cannot go outside of the grid.

// CODE:

import java.util.*;
class Solution {
    Set<String> blockedSet = new HashSet<>();
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    final int LIMIT = 200;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] b : blocked)
            blockedSet.add(b[0] + "," + b[1]);

        int maxArea = blocked.length * blocked.length;
        return bfs(source, target, maxArea) && bfs(target, source, maxArea);
    }

    private boolean bfs(int[] start, int[] end, int maxArea) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start[0] + "," + start[1]);

        int count = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == end[0] && curr[1] == end[1]) return true;
            if (++count > maxArea) return true;

            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                String pos = nx + "," + ny;
                if (nx >= 0 && ny >= 0 && nx < 1e6 && ny < 1e6 && 
                    !blockedSet.contains(pos) && !visited.contains(pos)) {
                    queue.offer(new int[]{nx, ny});
                    visited.add(pos);
                }
            }
        }

        return false;
    }
}