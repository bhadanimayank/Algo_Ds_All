/* Problem - https://leetcode.com/problems/partition-array-for-maximum-sum/description/

https://takeuforward.org/data-structure/partition-array-for-maximum-sum-front-partition-dp-54/


Code
Testcase
Testcase
Test Result
1043. Partition Array for Maximum Sum
Solved
Medium
Topics
Companies
Hint
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]
Example 2:

Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83
Example 3:

Input: arr = [1], k = 1
Output: 1
 

Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 109
1 <= k <= arr.length

*/

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(arr, k, 0, n, dp);
    }

    public int solve(int[] arr, int k, int ind, int n, int[] dp)
    {
        if( ind == n )
            return 0;

        if( dp[ind] != -1 )
            return dp[ind];

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        
        for( int j = ind; j < Math.min(ind + k, n); j++ )
        {
            ++len;
            maxi = Math.max(arr[j], maxi);
            int ans = (len * maxi) + solve(arr, k, j + 1, n, dp);
            max = Math.max(ans, max);
        }

        return dp[ind] = max;
    }
}


/* Notes

Let's take an example [ 1, 2, 3, 4, 5, 6, 7, 8 ] with k = 3. the ans would be something like [2, 2] [5, 5, 5] [8, 8, 8] or could be [1] [4, 4, 4] [7, 7, 7 ] [8] 

So what we are doing in solution we are generating all the possibilities. So we will generate the sets using recursion, but we are processing every set in the for loop.

Also, important to notice that while processing each set inside the for loop, we are also initiating sets from next element

*/
