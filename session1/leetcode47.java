// leetcode 47  permutatuions 

class solution{
    public <List<List<Integer>> permute(int[] nums){
        <List<List<Integer>> ans = new ArrayList<>();
        solve( nums,0, ans);
        return ans;
    }
    void solve(int[] nums, int, index, List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer>list = new ArrayList<>();

            for(int x: nums)
            list.add(x);

            ans.addd(list);
            return;
        }
        for(int i = index; i<nums.length; i++){
            swap(nums, index, i );
            solve(nums, index+1, ans);
            swap(nums, index, i);
        }
    }
    void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}