/* Problem - Perfect Sum Problem - https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
Given an array arr of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7.

Example 1:

Input: 
N = 6
arr = [5, 2, 3, 10, 6, 8]
sum = 10
Output: 
3
Explanation: 
{5, 2, 3}, {2, 8}, {10} are possible subsets.
Example 2:
Input: 
N = 5
arr = [2, 5, 1, 4, 3]
sum = 10
Output: 
3
Explanation: 
{2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.
Your Task:  
You don't need to read input or print anything. Complete the function perfectSum() which takes N, array arr and sum as input parameters and returns an integer value.

Expected Time Complexity: O(N*sum)
Expected Auxiliary Space: O(N*sum)

Constraints:
1 ≤ N*sum ≤ 106
0 ≤ arr[i] ≤ 106


*/

class Solution{
    
    int mod=(int)(1e9+7);

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n][sum + 1];
        
        for(int[] row: dp)
            Arrays.fill(row, -1);
            
        Arrays.sort(arr);
	    reverse(arr);
            
        return solveTabulation(arr, sum);
        // return solveRecursion(arr, dp, n - 1, sum);
        
	}
	
	public int solveTabulation(int[] arr, int target)
	{
	    int dp[][] = new int[arr.length + 1][target + 1];
	    
	    for(int row[] : dp){
	        Arrays.fill(row, -1);
	    }
	    
	    for(int i = 0; i <= arr.length; i++)
	        for(int j = 0; j <= target ; j++)
    	    {
    	        if(i == 0 && j == 0)
    	        {
	                dp[i][j] = 1;
    	        }
	            else if(i == 0 && j > 0 )
	            {
	                dp[i][j] = 0;
	            }
        	    else if( arr[i - 1] >  j)
        	    {
        	        dp[i][j] = dp[i -1][j] % mod;
        	    }
        	    else
        	    {
        	        dp[i][j] = ( dp[i -1][j] + dp[i - 1][j - arr[i - 1]] ) % mod;
        	    }
    	    }
    	 
    	 return dp[arr.length][target];
	}
	
	public int solveRecursion(int[] arr, int[][] dp, int index, int target)
	{
	    if( target == 0 )
	    {
	        return 1;
	    }
	    
	    if( index == 0 )
	    {
	        return arr[0] == target ? 1 : 0;
	    }
	    
	    if( dp[index][target] != -1 )
	    {
	        return dp[index][target];
	    }
	    
	    int nonTake = solveRecursion(arr, dp, index - 1, target);
	    
	    int take = 0;
	    
	    if(target >= arr[index])
	    {
	        take = solveRecursion(arr, dp, index - 1, target - arr[index]);
	    }
	    
	    return dp[index][target] = (nonTake + take) % mod;
	}
	
	public static void reverse(int[] arr)
    {
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        
    }
}

/*
    Here take note of this special case, we need to sort the array in descending order as input could contain 0 as one of the elements.
    Because we are solving from last index of the array, then it will calculate all the 0 in the subsets
    Otherwise if the 0 will fall in between the array . So 0 will be non considered if the solution is solved earlier in the array
*/