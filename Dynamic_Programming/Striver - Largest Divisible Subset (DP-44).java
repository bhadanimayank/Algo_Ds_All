/* Problem - https://leetcode.com/problems/largest-divisible-subset/submissions/1271581267/

https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/

368. Largest Divisible Subset
Solved
Medium
Topics
Companies
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.

*/

import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        Arrays.fill(hash, 1);

        for( int i = 0; i < n; i++ )
        {
            hash[i] = i;
            for( int prev_i = 0; prev_i < i; prev_i++ )
            {
                if( nums[i] % nums[prev_i] == 0 && dp[i] < dp[prev_i] + 1 )
                {
                    dp[i] = dp[prev_i] + 1;
                    hash[i] = prev_i;
                }
            }
        }

        int last_i = -1;
        int max = -1;

        for(int i = 0; i < n; i++)
        {
            if( dp[i] > max )
            {
                max = dp[i];
                last_i = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[last_i]);

        while(hash[last_i] != last_i)
        {
            int ind = hash[last_i];
            ans.add(0, nums[ind]);
            last_i = hash[last_i];
        }

        return ans;
    }
}

// Notes
Follows logic of bhadanimayank/Algo_Ds_All/Dynamic Programming/Striver - Printing Longest Increasing Subsequence|(DP-42).java, just instead of greater than we do %. Also the problem asks for subset not subsequence so sequence doesn't
matter. Therefore we have to sort the array
