/* Problem - https://leetcode.com/problems/edit-distance/description/

https://takeuforward.org/data-structure/edit-distance-dp-33/

72. Edit Distance
Solved
Medium
Topics
Companies
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.

*/

class Solution {
    public int minDistance(String word1, String word2) {
        
        // Solution 1
        int m = word1.length();
        int n = word2.length();

        int prevDP[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            prevDP[i] = i;
        }

        for(int i = 1; i <= m; i++)
        {
            int currDP[] = new int[n + 1];
            currDP[0] = i;

            for(int j = 1; j <= n; j++)
            {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    currDP[j] = prevDP[j - 1];
                else
                    currDP[j] = Math.min( prevDP[j], Math.min(currDP[j - 1], prevDP[j-1]) ) + 1;
            }
            prevDP = currDP;
        }

        // return prevDP[n];

        // Solution 2
        int[][] dp = new int[m][n];

        for(int[] row: dp)
            Arrays.fill(row, -1);

        return solve(word1, word2, m - 1, n - 1, dp);
        
    }

    public int solve(String word1, String word2, int m, int n, int[][] dp)
    {
        if(m < 0)
            return n + 1;

        if(n < 0)
            return m + 1;

        if(dp[m][n] != -1)
            return dp[m][n];

        if(word1.charAt(m) == word2.charAt(n))
            return dp[m][n] = solve(word1, word2, m - 1, n - 1, dp);
        else
            return dp[m][n] = 1 + 
                              Math.min( solve(word1, word2, m -1, n - 1, dp), 
                                        Math.min( 
                                                solve(word1, word2, m - 1, n, dp), 
                                                solve(word1, word2, m, n - 1, dp)
                                                ) 
                                        );
    }
}

/* Notes - Solution 2

So here the Problem asks to return the minimum number of steps required to be taken to match the two strings

So if the charactres match between two strings we just needs to move ahead, no operations are needed that is what happening in the if condition.

Now let's talk about the else condition. 

So 1st case, here let's take example of two strings "str" and "stb". Here we can match the strings by replacing either "r" in first string by "b"
or by replacing "b" in the second string by "r". In either case we perform 1 step and move the indices on both string by 1

So, that's why 1 + solve(word1, word2, m -1, n - 1, dp)

Now 2nd case, again take the same two example strings "str" and "st". Now we can match the two strings by deleting the "r" from first string.
So here we are performing 1 step and move one index from first string.

So, that's why 1 + solve(word1, word2, m - 1, n, dp)

At last 3rd case, suppose you have two strings "st" and "str". So you must add "r" from second string to first string. So by adding it
you are performing 1 step and now when it's matched you will move one index on the second string and we amove ahead with matching "t" on both string.

So, that's why 1 + solve(word1, word2, m, n - 1, dp)

So if characters are not matched possibility of all 3 cases needs to be evaluated and the case with minimum steps needs to be considered for solution
that's why 
             Math.min( solve(word1, word2, m -1, n - 1, dp), 
                                        Math.min( 
                                                solve(word1, word2, m - 1, n, dp), 
                                                solve(word1, word2, m, n - 1, dp)
                                                ) 
                                        );

Now let's talk about the base cases. Suppose if indexes have moved completely on any of the two strings beyound 0, that's means that strings have
already completely matched with the second strings, now second strings might have some characters left that's needs to be deleted.
As we have 0 based indexing that's why + 1

        if(m < 0)
            return n + 1;

        if(n < 0)
            return m + 1;

*/