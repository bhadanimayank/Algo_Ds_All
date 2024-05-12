/* Problem - https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=partitions-with-given-difference
Given an array arr, partition it into two subsets(possibly empty) such that each element must belong to only one subset. Let the sum of the elements of these two subsets be S1 and S2. 
Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference between S1 and S2 is equal to d. Since the answer may be large return it modulo 109 + 7.

Example 1:

Input:
n = 4
d = 3
arr[] =  { 5, 2, 6, 4}
Output: 1
Explanation:
There is only one possible partition of this array. Partition : {6, 4}, {5, 2}. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
Example 2:

Input:
n = 4
d = 0 
arr[] = {1, 1, 1, 1} 
Output: 6 
Explanation:
we can choose two 1's from indices {0,1}, {0,2}, {0,3}, {1,2}, {1,3}, {2,3} and put them in S1 and remaning two 1's in S2.
Thus there are total 6 ways for partition the array arr. 
Your Task:
You don't have to read input or print anything. Your task is to complete the function countPartitions() which takes the integer n and d and array arr and returns the count of partitions.

Constraint:
1 <= n <= 500
0 <= d  <= 25000
0 <= arr[i] <= 50

Expected Time Complexity: O( n*sum(arr))
Expected Space Complexity: O( sum(arr))

*/

class Solution {
    static int mod = (int)(1e9+7);
    public static int countPartitions(int n, int d, int[] arr) {
        
        int totalSum = 0;
        
        for(int i = 0; i < n; i++)
        {
            totalSum = totalSum + arr[i];
        }
        
        if( d > totalSum )
        {
            return 0;
        }
        
        // Checking if array could be divided and not into decimal 
        if( (totalSum - d) % 2 == 1)
        {
            return 0;
        }
        
        int target = (totalSum - d) / 2;
        
        int[][] dp = new int[n][target + 1];
        
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return solve(n - 1, arr, dp, target);
    }
    
    public static int solve(int index, int[] arr, int[][] dp, int target)
    {
        if(index == 0)
        {
            if(target == 0 && arr[0] == 0)
                return 2; // read notes
            if(target == arr[0])
                return 1;
            if(target == 0)
                return 1;
            return 0;
        }
        
        if(dp[index][target] != -1)
            return dp[index][target];
            
        
        if(target >= arr[index])
        {
            dp[index][target] = ( solve(index - 1, arr, dp, target - arr[index]) + solve(index - 1, arr, dp, target) ) % mod;
        }
        else
        {
            dp[index][target] = solve(index - 1, arr, dp, target) % mod;
        }
        
        return dp[index][target];
    }
}

/*
Notes
========================================================================================================================================

First Suppose Sum of the array is S and the partions Sums are going to be S1 and S2.
Then we have following equations => S1 + S2 = S 
                             and => S1 - S2 = d

Solving above we get S1 = (S - d)/2;

So we could find the number of subsets in array which are equal to S1, the left elements will form a subset with sum equal to S2

So now we have to find the number of ways we could achive S1 as sum of Subsets, So target is S1

========================================================================================================================================

Second very important case in this problem is that it contains 0 as a element, when solving the problem recursively from end of array to the
start of Array, notice that here in solution we are not stopping at target == 0 until unless we are at index 0. So we are already considering
all the 0's at the end and middle of array.

The Problem may be if at start of array is 0, then problem might have been solved before recursion reaches there, So each solution can be also solved by
including 0 at the start, So if arr[0] = 0 and target at the same time is 0, then count the solution as 2  

*/