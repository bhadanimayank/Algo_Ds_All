/*
Problem - https://www.naukri.com/code360/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

Problem statement
Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates. Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible with the help of his friends.

Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, ‘C’ - 1) in the grid. Each of them can move from their current cell to the cells just below them. When anyone passes from any cell, he will pick all chocolates in it, and then the number of chocolates in that cell will become zero. If both stay in the same cell, only one of them will pick the chocolates in it.

If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i + 1, j - 1) or (i + 1, j + 1). They will always stay inside the ‘GRID’.

Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following the above rules.

Example:
Input: ‘R’ = 3, ‘C’ = 4
       ‘GRID’ = [[2, 3, 1, 2], [3, 4, 2, 2], [5, 6, 3, 5]]
Output: 21

Initially Alice is at the position (0,0) he can follow the path (0,0) -> (1,1) -> (2,1) and will collect 2 + 4 + 6 = 12 chocolates.

Initially Bob is at the position (0, 3) and he can follow the path (0, 3) -> (1,3) -> (2, 3) and will colllect 2 + 2 + 5 = 9 chocolates.

Hence the total number of chocolates collected will be 12 + 9 = 21. there is no other possible way to collect a greater number of chocolates than 21.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= ‘T’ <= 10
2 <= 'R', 'C' <= 50
0 <= 'GRID[i][j]'<= 10^2
Time Limit: 1sec
Sample Input 1 :
2
3 4
2 3 1 2
3 4 2 2
5 6 3 5
2 2
1 1
1 2
Sample Output 1 :
21
5
Explanation Of Sample Input 1 :
For the first test case, Initially Alice is at the position (0, 0) he can follow the path (0, 0) -> (1, 1) -> (2, 1) and will collect 2 + 4 + 6 = 12 chocolates.

Initially Bob is at the position (0, 3) and he can follow the path (0, 3) -> (1, 3) -> (2, 3) and will collect 2 + 2 + 5 = 9 chocolates.

Hence the total number of chocolates collected will be 12 + 9 = 21.

For the second test case, Alice will follow the path (0, 0) -> (1, 0) and Bob will follow the path (0, 1) -> (1, 1). total number of chocolates collected will be 1 + 1 + 1 + 2 = 5
Sample Input 2 :
2
2 2
3 7
7 6
3 2
4 5
3 7
4 2
Sample Output 2 :
23
25

*/

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int dp[][][] = new int[m][n][n];

		// Initialize the dp array with -1
		for (int row1[][] : dp)
		{
			for (int row2[] : row1)
			{
				Arrays.fill(row2, -1);
			}
		}

		return maxChocoUtil(0, 0, n - 1, m - 1, n - 1, grid, dp);
	}

	static int maxChocoUtil(int i, int j1, int j2, int m, int n, int[][] grid,  int[][][] dp) {

		if ( j1 < 0 || j1 > n || j2 < 0 || j2 > n )
			return (int)(Math.pow( -10, 9 ));

		if ( i == m )
		{
			if ( j1 == j2 )
				return grid[i][j1];
			else
				return grid[i][j1] + grid[i][j2];
		}

		if ( dp[i][j1][j2] != -1 )
		{
			return dp[i][j1][j2];
		}

		int maxi = Integer.MIN_VALUE;

		for ( int di = -1 ; di <= 1 ; di++ )
		{
			for ( int dj = -1 ; dj <= 1 ; dj++  )
			{
				int ans;
				if ( j1 == j2 )
				{
					ans = grid[i][j1] + maxChocoUtil( i + 1, j1 + di, j2 + dj, m, n, grid, dp);
				}
				else
				{
					ans = grid[i][j1] + grid[i][j2] + maxChocoUtil( i + 1, j1 + di, j2 + dj, m, n, grid, dp);
				}
				maxi = Math.max( maxi, ans);
			}
		}

		return dp[i][j1][j2] = maxi;
 	}
}
