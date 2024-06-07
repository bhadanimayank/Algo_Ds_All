Problem 70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45

Solution
=======================================================================================================================================
class Solution {
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];

        if(n <= 0)
            return 1;
        if(n == 1)
            return 1;
        
        dp[0] = 1; dp[1] = 1;

        for(int i = 2 ; i <= n ; i++)
        {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
        
    }
}

Notes
======================================================================================================================================
Way to reach on step 0 -> 1
Way to reach on step 1->  1
Way to reach on step 2 -> from step 0 + from step 1 -> 1 + 1 -> 2
Way to reach on step 3 -> from step 1 + from step 2 -> 2 + 1 -> 3
Way to reach on step 4 -> from step 2 + from step 3 -> 2 + 3 -> 5

Similarly,
Way to reach on step n -> ways to reach step (n-2) + ways to reach step (n-1)
