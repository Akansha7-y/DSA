// ADDITIVE NUMBER 
// An additive number is a string whose digits can form an additive sequence.
// A valid additive sequence should contain at least three numbers. 
// Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
// Given a string containing only digits, return true if it is an additive number or false otherwise.
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

// Example 1:

// Input: "112358"
// Output: true
// Explanation: 
// The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// Example 2:

// Input: "199100199"
// Output: true
// Explanation: 
// The additive sequence is: 1, 99, 100, 199. 
// 1 + 99 = 100, 99 + 100 = 199


// CODE:


class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1)
                break;
            for (int j = i + 1; j < n; j++) {
                int len2 = j - i;
                if (Math.max(i, len2) > n - j)
                    break;
                if (num.charAt(i) == '0' && len2 > 1)
                    break;
                if (check(num, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    private boolean check(String num, int start,int mid, int end) {
        String a = num.substring(start, mid);
        String b = num.substring(mid, end);
        while (end < num.length()) {
            java.math.BigInteger sum =
                new java.math.BigInteger(a)
                .add(new java.math.BigInteger(b));
            String next = sum.toString();
            if (!num.startsWith(next, end))
                return false;
            end += next.length();
            a = b;
            b = next;
        }
        return true;
    }
}
