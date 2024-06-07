/* Problem - https://leetcode.com/problems/longest-palindromic-subsequence/description/

516. Longest Palindromic Subsequence
Solved
Medium
Topics
Companies
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.


*/

class Solution {
    public int longestPalindromeSubseq(String s) {

        // Improved Solution

        int m = s.length();

        int[] dp1 = new int[m + 1];
        Arrays.fill(dp1, 0);
        
        for(int i = 1; i <= m; i++)
        {
            int[] dp2 = new int[m + 1];
            dp2[0] = 0;
            for(int j = 1; j <= m; j++)
            {
                if( s.charAt(i - 1) == s.charAt(m - j) )
                {
                    dp2[j] = dp1[j - 1] + 1;
                }
                else
                {
                    dp2[j] = Math.max(dp1[j], dp2[j - 1]);
                }
            }
            dp1 = dp2;
        }

        return dp1[m];

        /* Initial Solution

        int m = s.length();

        int[][] dp = new int[m + 1][m + 1];
        
        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= m; j++)
            {
                if( i == 0 || j == 0 )
                {
                    dp[i][j] = 0;
                }
                else if( s.charAt(i - 1) == s.charAt(m - j) )
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][m];

        */
    }
}

/*Notes

Initial Solution

Let m = 5
i j|   Pointer 1 (i - 1)  | Pointer 2 (m - j)
0  |  -1                  | 5                   <- This case was ignored in the first if
1  |   0                  | 4                   <- From this case string will be compared from Both side
2  |   1                  | 3
3  |   2                  | 2
4  |   3                  | 1
5  |   4                  | 0

Improved Solution

Since we are only using current row and last row of dp array at given time.
So we can instead use only two 1d arrays dp1 and dp2 to solve the problem.

Also we can initialize dp1 to 0 and we can run first iteration from i = 1.
As we have already initialize the required first array to 0

Similarly we can initialize dp2[0] = 0 and run second iteration from j = 1

After each time second iterations completes we can point current array dp2 to prev array dp1

Also before second iteration starts each time, we need to initialize new dp2 array or initialized earlier both dp1 and dp2 will point to the same array

*/