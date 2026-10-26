// Combinations 
// two integer n and k, return all possible combinations of k numbers out of [1,n].

class Solution{
    static void combine(int start, int n, int k
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 1, n, k);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int start, int n, int k){
        if(tempList.size() == k){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i <= n; i++){
            tempList.add(i);
            backtrack(res, tempList, i + 1, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }
}