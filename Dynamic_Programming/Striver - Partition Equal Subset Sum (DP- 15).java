/*
Problem - https://www.naukri.com/code360/problems/partition-equal-subset-sum_892980?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

Problem statement
You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.

For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.

Follow Up:

Can you solve this using not more than O(S) extra space, where S is the sum of all elements of the given array?
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= 'T' <= 10
1 <= 'N' <= 100 
1 <= 'ARR'[i] <= 100

Time Limit: 1 sec
Sample Input 1:
2
6
3 1 1 2 2 1
5
5 6 5 11 6
Sample Output 1:
true
false    
Explanation Of Sample Input 1:
For the first test case, the array can be partitioned as ([2,1,1,1] and [3, 2]) or ([2,2,1], and [1,1,3]) with sum 5.

For the second test case, the array can’t be partitioned.
Sample Input 2:
2
9
2 2 1 1 1 1 1 3 3
6
8 7 6 12 4 5
Sample Output 2:
false
true

*/

import java.util.*;
public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		
		int sum = 0;

		for(int i = 0; i < arr.length; i++)
		{
			sum = sum + arr[i];
		}

		int[][] dp = new int[n][(sum * 2) + 1];

		for(int[] row: dp)
		{
			Arrays.fill(row, -1);
		}

		return solve(arr, n - 1, 0, dp);
	}

	public static boolean solve(int[] arr, int n, int cost, int[][] dp)
	{
		if ( n == -1 )
		{
			return cost == 0 ? true: false;
		}

		if ( cost >= 0 && dp[n][cost] != -1 )
		{
			return dp[n][cost] == 1 ? false : true;
		}

		if ( cost < 0 && dp[n][cost * -2] != -1 )
		{
			return dp[n][cost * -2] == 1 ? false : true;
		}

		boolean add = solve(arr, n - 1, cost + arr[n], dp );

		boolean minus = solve(arr, n - 1, cost - arr[n], dp );

		if (cost >= 0)
		{
			dp[n][cost] = (add || minus) ? 0 : 1;
		}
		else
		{
			dp[n][cost * -2] = (add || minus) ? 0 : 1;
		}

		return add || minus;
	}
}