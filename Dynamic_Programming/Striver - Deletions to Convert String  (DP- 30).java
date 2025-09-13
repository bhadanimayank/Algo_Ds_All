/* Problem - https://leetcode.com/problems/delete-operation-for-two-strings/submissions/1262094091/

https://takeuforward.org/data-structure/minimum-insertions-deletions-to-convert-string-dp-30/

583. Delete Operation for Two Strings
Solved
Medium
Topics
Companies
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.

*/

class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[] prevDP = new int[n + 1];

        Arrays.fill(prevDP, 0);

        for(int i = 1; i <= m; i++ )
        {
            int[] currDP = new int[n + 1];
            currDP[0] = 0;

            for(int j = 1; j <= n; j++)
            {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    currDP[j] = prevDP[j - 1] + 1;
                else
                    currDP[j] = Math.max(prevDP[j], currDP[j - 1]);
            }

            prevDP = currDP;
        }

        return (m + n) - (2 * prevDP[n]);
        
    }
}

/* Notes

Part1 - Palindrom Solution
------------------------------------------------------------------------------------------------------------------------------------------------

Since we are only using current row and last row of dp array at given time.
So we can instead use only two 1d arrays prevDP and currDP to solve the problem.

Also we can initialize prevDP to 0 and we can run first iteration from i = 1.
As we have already initialize the required first array to 0

Similarly we can initialize currDP2[0] = 0 and run second iteration from j = 1

After each time second iterations completes we can point current array to prev array

Also before second iteration starts each time, we need to initialize new currDP array or if initialized earlier both prevDP and currDP will point to the same array

Part2 - Character Deletion Solution
---------------------------------------------------------------------------------------------------------------------------------------------

The solution is we substract the longest common subsequence from both the strings, then the sum of the difference will be the answer

(m - k) + (n - k)

 m + n - 2k

*/
