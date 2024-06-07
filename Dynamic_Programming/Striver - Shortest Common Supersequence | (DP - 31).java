/* Problem - https://leetcode.com/problems/shortest-common-supersequence/description/
https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/

1092. Shortest Common Supersequence 
Solved
Hard
Topics
Companies
Hint
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.

*/

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int[][] dp = getDP(str1, str2, m, n);

        return constructSCS(str1, str2, m, n, dp);
        
    }

    public String constructSCS(String str1, String str2, int m, int n, int[][] dp)
    {
        String ans = "";

        while( m > 0 && n > 0 )
        {
            if( str1.charAt(m - 1) == str2.charAt(n - 1) )
            {
                ans = "" + str1.charAt(m - 1) + ans;
                --m;
                --n;
            }
            else if(dp[m - 1][n] > dp[m][n - 1])
            {
                // Pick and add charcater from str1 from (m - 1) if dp[m - 1][n] > dp[m][n - 1]
                ans = "" + str1.charAt(m - 1) + ans;
                --m;
            }
            else
            {
                // Pick and add charcater from str2 from (n - 1) if dp[m][n - 1] > dp[m - 1][n]
                ans = "" + str2.charAt(n - 1) + ans;
                --n;
            }
        }

        while( m > 0 )
        {
            ans = "" + str1.charAt(m - 1) + ans;
            --m;
        }

        while( n > 0 )
        {
            ans = "" + str2.charAt(n - 1) + ans;
            --n;
        }

        return ans;
    }

    public int[][] getDP(String str1, String str2, int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];

        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }

        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                }
                else if( str1.charAt(i - 1) == str2.charAt(j - 1) )
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max( dp[i - 1][j], dp[i][j - 1] );
                }
            }
        }

        return dp;
    }


}