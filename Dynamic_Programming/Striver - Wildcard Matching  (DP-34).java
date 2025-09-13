/* Problem - https://leetcode.com/problems/wildcard-matching/description/

44. Wildcard Matching
Solved
Hard
Topics
Companies
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.

*/

class Solution {
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int[] row: dp)
            Arrays.fill(row, -1);

        return solve(s, n - 1, p, m - 1, dp) == 0 ? true: false;
    }

    public int checkStars(String p, int m)
    {
        for(int i = 0 ; i <= m ; i++)
        {
            if(p.charAt(i) != '*')
                return 1;
        }
        return 0;
    }

    public int solve(String s, int n, String p, int m, int[][] dp)
    {
        if( n < 0 && m < 0 )
            return 0;
        
        if( n >= 0 && m < 0 )
            return 1;

        if( n < 0 && m >= 0 )
            return checkStars(p, m);

        if(dp[n][m] != -1)
            return dp[n][m];

        if(p.charAt(m) == '?' || s.charAt(n) == p.charAt(m))
            dp[n][m] = solve(s, n - 1, p, m - 1, dp);

        if(p.charAt(m) == '*')
            dp[n][m] = (solve(s, n - 1, p, m, dp)  == 0 ? true: false || solve(s, n , p, m - 1, dp)  == 0 ? true: false) == true ? 0 : 1;
        
        return dp[n][m];
    }
}

/* Notes
checkStars checks if the at the string has matched the pattren and if there remains one or more stars at the start of the pattern string

*/

/* Revision

11-08-2024 Read Revised

*/
