/* Problem - https://leetcode.com/problems/coin-change/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

*/

class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int[] row: dp)
            Arrays.fill(row, -1);

        int count = solve(coins, amount, n - 1, dp);
        return count >= (int) Math.pow(10, 9) ? -1 : count;      
    }

    public int solve(int[]coins, int amount, int n, int[][] dp) {

        if( n == 0 )
        {
            if(amount % coins[0] == 0)
                return amount / coins[0];

            return (int) Math.pow(10, 9);
        }

        if( dp[n][amount] != -1 )
            return dp[n][amount];

        int pick = (int) Math.pow(10, 9);
        
        if( amount >= coins[n])
        {
            pick = 1 + solve(coins, amount - coins[n], n, dp);
        }

        int nonPick = solve(coins, amount, n - 1, dp);

        return dp[n][amount] = Math.min(pick, nonPick);
    }
}

/*Notes

1st thing to note here is that if you are gonna do any addition to ressulting result of the recursion function and if the question is a min find problem
Never return Integer.MAX_VALUE from the base condition, becuase when below recurvice function will resolve to negative min of Integer range

1 + solve(coins, amount - coins[n], n, dp)

So, always return (int) Math.pow(10, 9);

================================================================================================================================================================

2nd thing to note that see if the min find problem is unsolvable, then the base case would have returned (int) Math.pow(10, 9) and all the recursive
solutions would have made additions on top of it 

1 + solve(coins, amount - coins[n], n, dp);

So at the end of it the solution returned will be > Math.pow(10, 9). So you can check if the solution is solvable or not by checking like below

return count >= (int) Math.pow(10, 9) ? -1 : count;    
*/