/* Problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

https://takeuforward.org/data-structure/buy-and-sell-stocks-with-cooldown-dp-39/

309. Best Time to Buy and Sell Stock with Cooldown
Solved
Medium
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 

Constraints:

1 <= prices.length <= 5000
0 <= prices[i] <= 1000

*/

class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int[][] dp = new int[2][n]; // Indicates buy and sell positions each day

        for(int[] row: dp)
            Arrays.fill(row, -1);

        return solve(prices, dp, 0, 0, n);
    }

    public int solve(int[] prices, int[][] dp, int bought, int index, int n)
    {
        if(index >= n)
            return 0;

        if(dp[bought][index] != -1)
            return dp[bought][index];

        int profit;

        if(bought == 0) // can buy
        {
            profit = Math.max(
                        solve(prices, dp, 0, index + 1, n), // did not buy
                        -prices[index] + solve(prices, dp, 1, index + 1, n) // did buy
            );
        }
        else // can sell
        {
            profit = Math.max(
                solve(prices, dp, 1, index + 1, n), // did not sell
                prices[index] + solve(prices, dp, 0, index + 2, n) // did sell and moved day index by 2 instead of 1 for cooldown
            );
        }

        return dp[bought][index] = profit;
    }
}