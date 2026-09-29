
// find all unique subsets geeks for geeks
//you are given an array arr[] of positive integers. The task is to find all distinct subsets of the given array. Note that the solution set must not contain duplicate subsets.

// arr[]=[1,5,6]
 //output=[[],[1],[1,5],[1,5,6],[1,6],[5],[5,6],[6]]



import java.util.*;
 class main {
    static void solution(int[] nums, int index, List<Integer> current, List<List<Integer>> ans){
        ans.add(new ArrayList<>(current));
        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue; // skip duplicates
            current.add(nums[i]);
            solution(nums, i+1, current, ans);
            current.remove(current.size()-1);}
        }
    
    public static void main(String[] args){
        int[] nums = {1,5,6};
        Arrays.sort(nums);                // sort the array to handle duplicates
        List<List<Integer>> ans = new ArrayList<>();
        solution(nums, 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
