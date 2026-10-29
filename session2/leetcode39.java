// Given an array of distinct positive integers candidates and a target, return all combinations whose sum equals the target.
// You can reuse the same candidate unlimited times.
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(
            int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
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
        if (remaining < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            // i, not i + 1: reuse is allowed
            backtrack(candidates, remaining - candidates[i],
                      i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
