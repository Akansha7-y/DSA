// Given an array that may contain duplicates and a target, return all unique combinations that sum to the target.
// Each array element can be used at most once.

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(
            int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0,
                  new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining,
                           int start, List<Integer> path,
                           List<List<Integer>> result) {

        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > remaining) {
                break;
            }

            path.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
