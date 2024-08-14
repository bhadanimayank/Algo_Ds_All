/* Problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

https://takeuforward.org/data-structure/stock-buy-and-sell/

121. Best Time to Buy and Sell Stock
Solved
Easy
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104


*/

class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int minBuy = prices[0];
        int profit = 0;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++)
        {
            minBuy = Math.min(minBuy, prices[i]);
            profit = prices[i] - minBuy;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit > 0 ? maxProfit : 0; 
    }
}

/* Notes

First check if there is a min buy price for at current day price.
In Second step check if the profit maximizes selling at current day price.

So that, the sell proce will always be in future.

*/