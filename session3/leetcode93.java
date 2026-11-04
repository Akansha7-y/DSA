// RESTORE IP ADDRESSES

// A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
// Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

// Example 1:

// Input: s = "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]
// Example 2:

// Input: s = "0000"
// Output: ["0.0.0.0"]
// Example 3:

// Input: s = "101023"
// Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]



// CODE:

import java.util.*;

class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        // IP address must have 4 parts
        backtrack(s, 0, 0, "", result);

        return result;
    }

    public void backtrack(String s, int index, int parts,
                          String current, List<String> result) {

        // If all 4 parts are completed
        if (parts == 4) {

            // All characters must be used
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }

            return;
        }

        // Try taking 1, 2 or 3 digits
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // Leading zero is not allowed
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            int num = Integer.parseInt(part);

            // Value must be between 0 and 255
            if (num > 255) {
                break;
            }

            // Recursive call
            backtrack(s, index + len, parts + 1,
                      current + part + ".", result);
        }
    }
}
