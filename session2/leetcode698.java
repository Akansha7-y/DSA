// // Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

// Example 1:

// Input: nums = [4,3,2,3,5,2,1], k = 4
// Output: true
// Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
// Example 2:

// Input: nums = [1,2,3,4], k = 3
// Output: false


import java.util.*;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int x: nums)
        sum += x;
        if(sum % k != 0)
        return false;

        int target = sum/k;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return solve(nums, k, 0, target, 0, used);

    }
    boolean solve(int[] nums, int k, int index, int target, int current, boolean[]used){
        if(k==1)
        return true;

        if(current == target)
        return solve(nums, k-1, 0, target, 0, used);
        for(int i = index; i<nums.length; i++){
            if(used[i])
            continue;

            used[i] = true;

            if(solve(nums, k, i+1, target, current + nums[i], used))
            return true;

            used[i]= false;
        }
        return false;
    }
}