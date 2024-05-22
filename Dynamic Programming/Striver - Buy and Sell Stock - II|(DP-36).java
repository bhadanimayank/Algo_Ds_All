/* Problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/1264976621/

https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/

122. Best Time to Buy and Sell Stock II
Solved
Medium
Topics
Companies
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104

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
        if(index == n)
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
                prices[index] + solve(prices, dp, 0, index + 1, n) // did sell
            );
        }

        return dp[bought][index] = profit;
    }
}