/* Problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

https://takeuforward.org/data-structure/buy-and-sell-stock-iii-dp-37/

123. Best Time to Buy and Sell Stock III
Solved
Hard
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105

*/

class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int[][][] dp = new int[n][2][3]; // dp indication days, buy & sell, 2 transaction cap indicator

        for(int[][] array: dp)
        {
            for(int[] row: array)
                Arrays.fill(row, -1);
        }

        return solve(prices, dp, 0, 0, n, 2);
    }

    public int solve(int[] prices, int[][][] dp, int bought, int index, int n, int cap)
    {
        if(index == n || cap == 0)
            return 0;

        if(dp[index][bought][cap] != -1)
            return dp[index][bought][cap];

        int profit;

        if(bought == 0) // can buy
        {
            profit = Math.max(
                solve(prices, dp, 0, index + 1, n, cap),
                -prices[index] + solve(prices, dp, 1, index + 1, n, cap)
            );
        }
        else // can sell
        {
            profit = Math.max(
                solve(prices, dp, 1, index + 1, n, cap),
                prices[index] + solve(prices, dp, 0, index + 1, n, cap - 1)
            );
        }

        return dp[index][bought][cap] = profit;
    }
}