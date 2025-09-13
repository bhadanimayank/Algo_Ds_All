/* Problem - https://leetcode.com/problems/longest-common-subsequence/description/

1143. Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.

*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int[] row: dp)
            Arrays.fill(row, -1);

        return solve(text1, n - 1, text2, m - 1, dp);
    }

    public int solve(String text1, int n, String text2, int m, int[][] dp)
    {

        if(n < 0 || m < 0)
            return 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(text1.charAt(n) == text2.charAt(m))
        {
            dp[n][m] = solve(text1, n -1, text2, m -1, dp) + 1;
        }
        else
        {
            dp[n][m] = Math.max(solve(text1, n -1, text2, m, dp) , solve(text1, n, text2, m -1, dp));
        }

        return dp[n][m];

    }
}

/*Notes
Good Base Example of two pointers
*/
