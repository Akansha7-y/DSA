// 1593 SPLIT A STRING INTO THE MAXIMUM NUMBER OF UNIQUE SUBSTRINGS

// // Given a string s, return the maximum number of unique substrings that the given string can be split into.

// You can split string s into any list of non-empty substrings, 
// where the concatenation of the substrings forms the original string. 
// However, you must split the substrings such that all of them are unique.

// A substring is a contiguous sequence of characters within a string.

// Example 1:
// Input: s = "ababccc"
// Output: 5
// Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc'].
//  Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
// Example 2:

// Input: s = "aba"
// Output: 2
// Explanation: One way to split maximally is ['a', 'ba'].

// CODE:

import java.util.*;
class Solution {
    int max = 0;
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        backtrack(s, 0, set);
        return max;
    }
    void backtrack(String s, int index, HashSet<String> set) {
        if (index == s.length()) {
            max = Math.max(max, set.size());
   return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (!set.contains(sub)) {
                set.add(sub);
                backtrack(s, i, set);
                set.remove(sub);
            }
        }
    }
}
