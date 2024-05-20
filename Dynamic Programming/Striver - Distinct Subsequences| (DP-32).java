/* Problem - https://leetcode.com/problems/distinct-subsequences/description/
https://takeuforward.org/data-structure/distinct-subsequences-dp-32/

115. Distinct Subsequences
Solved
Hard
Topics
Companies
Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:

1 <= s.length, t.length <= 1000
s and t consist of English letters.

*/

class Solution {
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m][n];

        for(int[] row: dp)
            Arrays.fill(row, -1);

        return solve(s, t, m - 1, n - 1, dp);
    }

    public static int solve(String s, String t, int m, int n, int[][] dp)
    {

        if(n < 0)
        {
            return 1;
        }

        if(m < 0)
        {
            return 0;
        }

        if(dp[m][n] != -1)
            return dp[m][n];

        if(s.charAt(m) == t.charAt(n))
        {
            int took = solve(s, t, m - 1, n - 1, dp);
            int leave = solve(s, t, m - 1, n, dp);
            dp[m][n] = took + leave;
        }
        else
            dp[m][n] = solve(s, t, m - 1, n, dp);

        return dp[m][n];

    }
}