 
import java.util.*;
 class Solution{
    public ArrayList<String> find_permutation(String S){
        ArrayList<String> ans = new ArrayList<>();
        char[] arr = S.toCharArray();

        Arrays.sort(arr);
        solve(arr,0,ans);
        return ans;
    }
    void solve(char[] arr, int index, ArrayList<String> ans){
        if(index == arr.length){
            ans.add(new String(arr));
            return;
        }

        HashSet<Character> used = new HashSet<>();
        for(int i=index;i<arr.length;i++){
            if(used.contains(arr[i]))          //if(i!=index && arr[i]==arr[index]) continue;
               continue;
            used.add(arr[i]);
            swap(arr,i,index);
            solve(arr,index+1,ans);
            swap(arr,i,index);
        }
    }
    void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 }