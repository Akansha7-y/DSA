//Power set using recursion gfg

import java.util.*;
class solution{
    public ArrayList<String>powerSet(String s){
        ArrayList<String> ans = new ArrayList<>();
        solve(s, 0, "", ans);
        Collections.sort(ans);
        return ans;
    }
    void solve(String s, int index, String current, ArrayList<String> ans){
        if(index== s.length()){
            ans.add(current);
                return;
            
        }
        solve(s, index+1, ans, current);
        solve(s, index+1, current+s.charAt(index), ans);
    }
}