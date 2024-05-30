/* Problem - https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

https://takeuforward.org/data-structure/number-of-longest-increasing-subsequences-dp-47/

673. Number of Longest Increasing Subsequence
Solved
Medium
Topics
Companies
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106

*/

class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxi = 1;

        for( int i = 0; i < n; i++ )
        {
            for( int prev_i = 0 ; prev_i < i ; prev_i++ )
            {
                if( nums[i] > nums[prev_i] && dp[i] < dp[prev_i] + 1 )
                {   
                    dp[i] = dp[prev_i] + 1;
                    count[i] = count[prev_i];
                }
                else if( nums[i] > nums[prev_i] && dp[i] == dp[prev_i] + 1 )
                {   
                    count[i] = count[i] + count[prev_i];
                }

            }
            maxi = Math.max(maxi,dp[i]);
        }

        int total_Count = 0;
        for( int i = 0 ; i < n; i++ )
        {
            if( dp[i] == maxi )
            {
                total_Count = total_Count + count[i];
            }
        }

        return total_Count;
    }
}

/* Notes

So there could be two case

1) [1, 3, 5, 4, 7]. So there are two LIS of same length [1, 3, 5, 7] and [1, 3, 4, 7]. SO both LIS end at same element i.e. 7

So dp will be like [*, * ,*, * , 4]. So even both LIS are ending at same place. It only indicates the length not the count.

So that's why we implement count array and initialize t to 1

if( nums[i] > nums[prev_i] && dp[i] < dp[prev_i] + 1 )
{   
    dp[i] = dp[prev_i] + 1;
    count[i] = count[prev_i];
    -> What we do here is count if any index is part of any LIS. So if the index is involved in single LIS, 1 will be copied from previos index
}
else if( nums[i] > nums[prev_i] && dp[i] == dp[prev_i] + 1 )
{   
    count[i] = count[i] + count[prev_i];
    -> But if element is coming again as part of another LIS. So current count[i] wiill be incremented by count[prev_i]. We are not increasing not by 1
       becasue nums[prev_i] may already be part of multiple LIS
}

That's how we count LIS ending at same index

2) [7, 8, 9, 1, 2, 3]. Here are also two LIS [7, 8, 9] and [1, 2, 3]. But here both LIS end at different indices

        int total_Count = 0;
        for( int i = 0 ; i < n; i++ )
        {
            if( dp[i] == maxi )
            {
                total_Count = total_Count + count[i];
            }
        }

    we solve it by fiding by summing counts where dp[i] having maximum LIS length

*/