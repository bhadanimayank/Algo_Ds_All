/* Problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

https://takeuforward.org/data-structure/buy-and-sell-stock-iv-dp-38/

188. Best Time to Buy and Sell Stock IV
Solved
Hard
Topics
Companies
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

1 <= k <= 100
1 <= prices.length <= 1000
0 <= prices[i] <= 1000

*/

class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;

        int[][][] dp = new int[n][2][k + 1]; // dp indication days, buy & sell, 2 transaction cap indicator

        for(int[][] array: dp)
        {
            for(int[] row: array)
                Arrays.fill(row, -1);
        }

        return solve(prices, dp, 0, 0, n, k);
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
