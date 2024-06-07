/*
Problem - https://www.naukri.com/code360/problems/maze-obstacles_977241?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
==============================================================================================================================

Problem statement
Given a ‘N’ * ’M’ maze with obstacles, count and return the number of unique paths to reach the right-bottom cell from the top-left cell. A cell in the given maze has a value '-1' if it is a blockage or dead-end, else 0. From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only. Since the answer can be large, print it modulo 10^9 + 7.

For Example :
Consider the maze below :
0 0 0 
0 -1 0 
0 0 0

There are two ways to reach the bottom left corner - 

(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)

Hence the answer for the above test case is 2.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 10
1 <= N,M <= 200

Note: It is guaranteed that the top-left cell does not have an obstacle.

Time Limit: 1 sec
Sample Input 1 :
2    
2 2
0 0
0 0
3 3
0 0 0 
0 -1 0 
0 0 0
Sample Output 1 :
2
2
Explanation For Sample Output 1 :
For the first test case, there are two possible paths to reach (2, 2) from (1, 1) : 
    (1, 1) -> (1, 2) -> (2, 2)
    (1, 1) -> (2, 1) -> (2, 2)

For the second test case, there are two ways to reach the bottom left corner - 
(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)
Sample Input 2 :
1
2 2
0 -1
-1  0
Sample Output 2 :
0

==============================================================================================================================

Solution

/*

import java.util.*;
public class Solution {
     static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.

        int dp[][] = new int[n][m];

		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0; j < m ; j++)
			{
				dp[i][j] = -1;
			}
		}

		return solve(mat, dp, n - 1, m - 1, 0, 0);
    }

    public static int solve(ArrayList<ArrayList<Integer>> mat, int[][] dp, int dx, int dy, int cx, int cy)
	{
		int mod=(int)(1e9+7);

		if ( cx == dx && cy == dy )
		{
			return 1;
		}

		if ( cx > dx || cy > dy )
		{
			return 0;
		}

        if ( mat.get(cx).get(cy) == -1 )
        {
            return dp[cx][cy] = 0;
        }

		if ( dp[cx][cy] != -1 )
			return dp[cx][cy];

		return dp[cx][cy] = ( solve(mat, dp, dx, dy, cx + 1, cy) + solve(mat, dp, dx, dy, cx, cy + 1) ) % mod;
	}

}
