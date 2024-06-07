/* Problem - https://leetcode.com/problems/longest-increasing-subsequence/solutions/4509129/99-54-easy-solution-with-explanation/

https://takeuforward.org/data-structure/longest-increasing-subsequence-dp-41/

300. Longest Increasing Subsequence
Solved
Medium
Topics
Companies
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

*/

class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for(int[] row: dp)
            Arrays.fill(row, -1);

        return solve(dp, nums, 0, n - 1, -1);
    }

    public int solve(int[][] dp, int[] nums, int i, int n, int lastIndex)
    {
        if( i > n )
        {
            return 0;
        }

        if( lastIndex != -1 && dp[i][lastIndex + 1] != -1 )
            return dp[i][lastIndex + 1];

        int took = 0;

        if( lastIndex == -1 || nums[i] > nums[lastIndex] )
        {
            took = 1 + solve(dp, nums, i + 1, n, i);
        }

        int nonTake = solve(dp, nums, i + 1, n, lastIndex);

        return dp[i][lastIndex + 1] = Math.max(took, nonTake);
    }
}

/* Notes

okay important note here whenever a choice needed to be made on on the first index over recursion with DP. Always create a dp with length n + 1.
So you an always store data for index i at dp[i + 1]. So index for i = -1 will be stored at dp[-1 + 1] = dp[0]

Also the initial mistke I did here is I wrote the logic as 

if( lastIndex == -1 || nums[i] < nums[lastIndex] )
{
    nonTake = solve(dp, nums, i + 1, n, lastIndex);
}

Never do such thing because lastIndex will never be updated in recursion. So the parameter that's needs to be updated in recursion, never put that in condition with same variable.
Always use the paremeter in the condition where that parameter needs to be updated.

Learning from this proble is to how to handle situation with index 0 and index -1 at the same conditional event

*/
