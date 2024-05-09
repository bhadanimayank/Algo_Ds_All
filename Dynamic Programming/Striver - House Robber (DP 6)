Problem statement - https://www.naukri.com/code360/problems/house-robber_839733?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
==================================================================================================================================================================
Mr. X is a professional robber planning to rob houses along a street. Each house has a certain amount of money hidden.
All houses along this street are arranged in a circle. That means the first house is the neighbour of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses are broken into on the same night.
You are given an array/list of non-negative integers 'ARR' representing the amount of money of each house. Your task is to return the maximum amount of money Mr. X can rob tonight without alerting the police.

Note:
It is possible for Mr. X to rob the same amount of money by looting two different sets of houses. Just print the maximum possible robbed amount, irrespective of sets of houses robbed.

For example:
(i) Given the input array arr[] = {2, 3, 2} the output will be 3 because Mr X cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses. So, he’ll rob only house 2 (money = 3)
(ii) Given the input array arr[] = {1, 2, 3, 1} the output will be 4 because Mr X rob house 1 (money = 1) and then rob house 3 (money = 3).
(iii) Given the input array arr[] = {0} the output will be 0 because Mr. X has got nothing to rob.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 5 x 10 ^ 3
1 <= ARR[i] <= 10 ^ 9

Time limit: 1 sec.
Sample Input 1:
3
1
0
3
2 3 2
4
1 3 2 1
Sample Output 1:
0
3
4
Explanation of Input 1:
(i) Mr. X has only one house to rob, but with no money.
(ii) Mr. X cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses (remember, it’s a circular street). So, he’ll rob only house 2 (money = 3) with a maximum value
(iii) Mr. X will get maximum value when he robs house 2 (money = 3) and then robs house 4 (money = 1) i.e. 4 units of money.
Sample Input 2:
3
5
1 5 1 2 6
3
2 3 5
4
1 3 2 0
Sample Output 2:
11
5
3


=================================================================================================================================================================
Solution 
=================================================================================================================================================================

import java.util.* ;
import java.io.*; 
public class Solution {
	public static long houseRobber(int[] valueInHouse) {

		if ( valueInHouse.length==1 ) {
	            return valueInHouse[0];
	        }

		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> last = new ArrayList<Integer>();

		for(int i = 0 ; i < valueInHouse.length; i++)
		{
			if ( i != 0 )
				first.add(valueInHouse[i]);

			if ( i != (valueInHouse.length -1) )
				last.add(valueInHouse[i]);
		}
		
		return Math.max(solve(first), solve(last));

		// return plunder(valueInHouse, valueInHouse.length - 1, true) ;
	}	

	public static long solve(ArrayList<Integer> arr) {

		if ( arr.size()==1 ) {
	            return arr.get(0);
	        }

		if ( arr.size() ==2 ) {
	            return Math.max(arr.get(0), arr.get(1));
	        }

		long[] dp = new long[arr.size()];
		dp[0] = arr.get(0);
		dp[1] = Math.max( arr.get(0), arr.get(1) );

		for( int i = 2 ; i < arr.size(); i++ )
		{
			dp[i] = Math.max(dp[i - 1] , dp[ i - 2] + arr.get(i));
		}

		return dp[arr.size() - 1];
	}

	/*
	public static int plunder(int[] valueInHouse, int n, boolean lastSelected)
	{
		if( n == valueInHouse.length - 1 && n == 0)
			return valueInHouse[0];

		if ( n == 0 )
		{
			return lastSelected ?  0 : valueInHouse[0] ;
		}

		if ( n < 0 )
		{
			return 0;
		}

		int pick = valueInHouse[n] + plunder(valueInHouse, n - 2, lastSelected);

		int miss = plunder(valueInHouse, n - 1, n == (valueInHouse.length - 1) ? false : lastSelected );

		return Math.max(pick, miss);
	}
	*/
}

=================================================================================================================================================================
