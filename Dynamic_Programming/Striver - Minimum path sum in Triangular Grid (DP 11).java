/*
Problem - https://www.naukri.com/code360/problems/triangle_1229398?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

=================================================================================================================================

Problem statement
You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.

The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.

You can move only to the adjacent number of row below each step. For example, if you are at index j in row i, then you can move to i or i + 1 index in row j + 1 in each step.

For Example :
If the array given is 'TRIANGLE' = [[1], [2,3], [3,6,7], [8,9,6,1]] the triangle array will look like:

1
2,3
3,6,7
8,9,6,10

For the given triangle array the minimum sum path would be 1->2->3->8. Hence the answer would be 14.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 5
1 <= N <= 10^3 
-10^6 <= TRIANGLE[i][pos] <= 10^6 ,                

Where 'TRIANGLE[i][pos]' is the element at row = 'i' & position = 'pos' in triangle array.  

Time limit: 1 sec
Sample Input 1 :
2
4
2 
3 4
6 5 7
4 1 8 3
1
-10 
Sample output 1 :
11
-10
Sample Input explanation:
Test case 1:
Here our triangle array is:

2
3 4
6 5 7 
4 1 8 3

In this array, the minimum path will be 2->3->5->1, so the minimum sum path would be 2+3+5+1=11

Test case 2:
In this case, there is one row. Thus, the minimum path will be -10, and the minimum sum path=-10.
Sample input 2 :
2
4
1
2 3
4 5 6
7 8 9 10
3
5
-1 3
22 1 -9
Sample Output 2 :
14
-1

=================================================================================================================================

Solution
*/

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.

        int[][] dp = new int[n][n];

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0; j < n ; j++)
            {
                dp[i][j] = -1;
            }
        }

        return solve( 0, 0, n -1, dp, triangle);
    }

    public static int solve( int i, int j, int n, int[][] dp, int[][] grid )
    {
        if ( dp[i][j] != -1 )
        {
            return dp[i][j];
        }

        if( i > n || j > n || j > n )
        {
            return Integer.MAX_VALUE;
        }

        if ( i == n )
        {
            return grid[i][j];
        }
        
        int cost = grid[i][j] + Math.min( solve( i + 1, j, n, dp, grid ) , solve( i + 1, j + 1, n, dp, grid) );

        return dp[i][j] = cost;
    }
}