/* Problem - https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

https://takeuforward.org/data-structure/minimum-insertions-to-make-string-palindrome-dp-29/

1312. Minimum Insertion Steps to Make a String Palindrome
Solved
Hard
Topics
Companies
Hint
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters

*/

class Solution {
    public int minInsertions(String s) {

        int m = s.length();

        int[] prevDP = new int[m + 1];

        Arrays.fill(prevDP, 0);

        for(int i = 1; i <= m; i++ )
        {
            int[] currDP = new int[m + 1];
            currDP[0] = 0;

            for(int j = 1; j <= m; j++)
            {
                if(s.charAt(i - 1) == s.charAt(m - j))
                    currDP[j] = prevDP[j - 1] + 1;
                else
                    currDP[j] = Math.max(prevDP[j], currDP[j - 1]);
            }

            prevDP = currDP;
        }

        return m - prevDP[m];
        
    }
}

/* Notes

Part1 - Palindrom Solution
------------------------------------------------------------------------------------------------------------------------------------------------
Let m = 5
i,j |   Pointer 1 (i - 1)  | Pointer 2 (m - j)
0   |  -1                  | 5                   <- This case was ignored in the iteration it starts from i,j = 1
1   |   0                  | 4                   <- From this case string will be compared from Both side
2   |   1                  | 3
3   |   2                  | 2
4   |   3                  | 1
5   |   4                  | 0

Since we are only using current row and last row of dp array at given time.
So we can instead use only two 1d arrays prevDP and currDP to solve the problem.

Also we can initialize prevDP to 0 and we can run first iteration from i = 1.
As we have already initialize the required first array to 0

Similarly we can initialize currDP2[0] = 0 and run second iteration from j = 1

After each time second iterations completes we can point current array to prev array

Also before second iteration starts each time, we need to initialize new currDP array or if initialized earlier both prevDP and currDP will point to the same array

Part2 - Character Insertion Solution
---------------------------------------------------------------------------------------------------------------------------------------------
Suppose for any string abcdba (length = 6), we can find the length of the existing longest palindrom existing in the string.
In this case that would be 4 i.e. abba. The chracter dc is extra in the palindrom.

So if we insert cd (length 2) in the string, it will be become a palindorm. i.e. abdccdba.
So number of charcaters we needed to insert is (total length of string - longest existing palindorm in the string), i.e. the answer
in above case (6 - 4) = 2

*/
