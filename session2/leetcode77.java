// Given two integers n and k, return all possible combinations of k numbers chosen from 1 to n.

// Example:
// Input: n = 4, k = 2

// Output:
// [[1,2], [1,3], [1,4],
//  [2,3], [2,4], [3,4]]


import java.util.*;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int n, int k,
                           List<Integer> path,
                           List<List<Integer>> result) {
        // Base case
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Try each number
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path, result);
            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}