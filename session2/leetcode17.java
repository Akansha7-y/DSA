// Letter combinations of the phone number
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]


import java.util.*;


class Solution {
    String[] keypad={
        "","","abc","def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0)
        return ans ;

        solve(digits, 0, "", ans );
        return ans;

    }
    void solve(String digits, int index, String current, List<String> ans ){
        if(index == digits.length()){
            ans.add(current);
            return;
        }
        String letters= keypad[digits.charAt(index)-'0'];
        for(char ch : letters.toCharArray()){
            solve(digits, index+1, current+ch , ans );
        }
    }
}