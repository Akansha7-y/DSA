// Letter case permutation 
// eg. input= s="a1b2"
// output = ["a1b2","a1B2","A1b2","A1B2"]


import java.util.*;

class Solution{
    public List<String> lettercasepermutation(String s){
        List <String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        solve(arr,0, ans);
        return ans;
    }
    void solve(char[] arr, int index, List<String> ans){
        if(index == arr.length){
            ans.add(new String(arr));
            return;
        }
        if(Character.isDigit(arr[index])){
            solve(arr,index+1,ans);
        }else{
            arr[index] = Character.toLowerCase(arr[index]);
            solve(arr,index+1,ans);
            arr[index] = Character.toUpperCase(arr[index]);
            solve(arr,index+1,ans);
        }
    }
}