/* Problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/submissions/1265054915/

https://takeuforward.org/data-structure/buy-and-sell-stocks-with-transaction-fees-dp-40/

714. Best Time to Buy and Sell Stock with Transaction Fee
Solved
Medium
Topics
Companies
Hint
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.
 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 

Constraints:

1 <= prices.length <= 5 * 104
1 <= prices[i] < 5 * 104
0 <= fee < 5 * 104

*/

class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;

        int[][] dp = new int[2][n]; // Indicates buy and sell positions each day

        for(int[] row: dp)
            Arrays.fill(row, -1);

        return solve(prices, dp, 0, 0, n, fee);
    }

    public int solve(int[] prices, int[][] dp, int bought, int index, int n, int fee)
    {
        if(index >= n)
            return 0;

        if(dp[bought][index] != -1)
            return dp[bought][index];

        int profit;

        if(bought == 0) // can buy
        {
            profit = Math.max(
                        solve(prices, dp, 0, index + 1, n, fee), // did not buy
                        -prices[index] + solve(prices, dp, 1, index + 1, n, fee) // did buy
            );
        }
        else // can sell
        {
            profit = Math.max(
                solve(prices, dp, 1, index + 1, n, fee), // did not sell
                (prices[index] - fee) + solve(prices, dp, 0, index + 1, n, fee) // did sell and moved day index by 2 instead of 1 for cooldown
            );
        }

        return dp[bought][index] = profit;
    }
}
