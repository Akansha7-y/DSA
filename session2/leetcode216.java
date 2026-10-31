// Combinations Sum 3
// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, 
// and the combinations may be returned in any order.

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.



import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1,k,n, new ArrayList<>(), ans);
        return ans;
    }
    void solve(int start, int k, int target, List<Integer>current, List<List<Integer>> ans){
        if(k == 0 ){
            if(target == 0)
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i <= 9; i++){
            if(i > target)
            break;
            current.add(i);
            solve(i+1,k-1, target-i, current, ans);
            current.remove(current.size()-1);
        }
    }
}