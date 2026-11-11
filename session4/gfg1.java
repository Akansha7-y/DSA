
// rat in maze question of gfg solutionn in java


// The Rat in a Maze problem is a classic Backtracking + DFS question.


// CODE:

class Solution {
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        
        ArrayList<String> ans = new ArrayList<>();
        
        int n = maze.length;
        
        // If starting or ending cell is blocked
        if (maze[0][0] == 0 || maze[n-1][n-1] == 0) {
            return ans;
        }
        
        boolean[][] visited = new boolean[n][n];
        
        solve(0, 0, maze, n, visited, "", ans);
        
        return ans;
    }
    
    public void solve(int row, int col, int[][] maze, int n,
                      boolean[][] visited, String path,
                      ArrayList<String> ans) {
        
        // Destination reached
        if (row == n-1 && col == n-1) {
            ans.add(path);
            return;
        }
        
        // Mark current cell visited
        visited[row][col] = true;
        
        // Down
        if (row+1 < n && maze[row+1][col] == 1 
            && !visited[row+1][col]) {
            
            solve(row+1, col, maze, n, visited,
                  path + "D", ans);
        }
        
        // Left
        if (col-1 >= 0 && maze[row][col-1] == 1 
            && !visited[row][col-1]) {
            
            solve(row, col-1, maze, n, visited,
                  path + "L", ans);
        }
        
        // Right
        if (col+1 < n && maze[row][col+1] == 1 
            && !visited[row][col+1]) {
            
            solve(row, col+1, maze, n, visited,
                  path + "R", ans);
        }
        
        // Up
        if (row-1 >= 0 && maze[row-1][col] == 1 
            && !visited[row-1][col]) {
            
            solve(row-1, col, maze, n, visited,
                  path + "U", ans);
        }
        
        // Backtracking
        visited[row][col] = false;
    }
}

