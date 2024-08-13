/*
Problem - https://www.naukri.com/code360/problems/unbounded-knapsack_1215029?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

Problem statement
You are given ‘n’ items with certain ‘profit’ and ‘weight’ and a knapsack with weight capacity ‘w’.



You need to fill the knapsack with the items in such a way that you get the maximum profit. You are allowed to take one item multiple times.



Example:
Input: 
'n' = 3, 'w' = 10, 
'profit' = [5, 11, 13]
'weight' = [2, 4, 6]

Output: 27

Explanation:
We can fill the knapsack as:

1 item of weight 6 and 1 item of weight 4.
1 item of weight 6 and 2 items of weight 2.
2 items of weight 4 and 1 item of weight 2.
5 items of weight 2.

The maximum profit will be from case 3 = 11 + 11 + 5 = 27. Therefore maximum profit = 27.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 15
7 2 4
5 10 20

Expected Answer:
21


Output on console:
21


Explanation of Sample Input 1
The given knapsack capacity is 15. We can fill the knapsack as [1, 1, 1] giving us profit 21 and as [1,2] giving us profit 9. Thus maximum profit will be 21.


Sample Input 2
2 3
6 12
4 17


Expected Answer:
0


Output on console:
0


Explanation of Sample Input 2:
We can clearly see that no item has weight less than knapsack capacity. Therefore we can not fill knapsack with any item.


Expected Time Complexity:
Try to solve this in O(n*w).


Constraints
1 <= n <= 10^3
1 <= w <= 10^3
1 <= profit[i] , weight[i] <= 10^8

Time Limit: 1 sec

*/

import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int[][] dp = new int[n][w + 1];

        for( int[] row: dp )
            Arrays.fill(row, -1);


        return solveKnapsack(0, n -1, w, profit, weight, dp);
       
    }

    public static int solveKnapsack(int i, int n, int w, int[] profit, int[] weight, int[][] dp)
    {
        if( i == n )
        {
            // When we are picking last item it's not necessary to check if the weight of last item is more then the 
            // remaining weight as we are typecasting it to integer.
            // if it's less, answer will come in decimal which will be typecasted to 0 only.
            
            return (int)(w/weight[i]) * profit[i];
        }

        if ( i >= n )
        {
            return Integer.MIN_VALUE;
        }

        if( dp[i][w] != -1 )
            return dp[i][w];

        int nonPick = solveKnapsack(i + 1, n, w, profit, weight, dp);

        int pick = Integer.MIN_VALUE;

        if( weight[i] <= w )
        {
            pick = profit[i] + solveKnapsack(i, n, w - weight[i] , profit, weight, dp);
        }

        return dp[i][w] = Math.max(pick, nonPick);

    }
}
