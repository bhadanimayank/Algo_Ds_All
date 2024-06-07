/* Problem - https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=matrix-chain-multiplication

https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/

Matrix Chain Multiplication
HardAccuracy: 49.64%Submissions: 107K+Points: 8
Skill-Up Summer Sale! Get 30% Off on all GfG Courses.
Get Certified this Summer!

banner
Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).

Example 1:

Input: N = 5
arr = {40, 20, 30, 10, 30}
Output: 26000
Explanation: There are 4 matrices of dimension 
40x20, 20x30, 30x10, 10x30. Say the matrices are 
named as A, B, C, D. Out of all possible combinations,
the most efficient way is (A*(B*C))*D. 
The number of operations are -
20*30*10 + 40*20*10 + 40*10*30 = 26000.

Example 2:

Input: N = 4
arr = {10, 30, 5, 60}
Output: 4500
Explanation: The matrices have dimensions 
10*30, 30*5, 5*60. Say the matrices are A, B 
and C. Out of all possible combinations,the
most efficient way is (A*B)*C. The 
number of multiplications are -
10*30*5 + 10*5*60 = 4500.

Your Task:
You do not need to take input or print anything. Your task is to complete the function matrixMultiplication() which takes the value N and the array arr[] as input parameters and returns the minimum number of multiplication operations needed to be performed.


Expected Time Complexity: O(N3)
Expected Auxiliary Space: O(N2)


Constraints: 
2 ≤ N ≤ 100
1 ≤ arr[i] ≤ 500

*/

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int i = 1;
        int j = N - 1;
        int[][] dp = new int[N][N];
        
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return solve(arr, dp, i, j);
    }
    
    static int solve(int arr[], int[][] dp, int i, int j)
    {
        if( i == j )
            return 0;
            
        if( dp[i][j] != -1 )
            return dp[i][j];
            
        int min = Integer.MAX_VALUE;
        
        for( int k = i; k < j; k++ )
        {
            int ans = solve(arr, dp, i, k) + solve(arr, dp, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            
            min = Math.min(min, ans);
        }
        
        return dp[i][j] = min;
    }
}

/* Notes
Let's understand by example

for( int k = i; k < j; k++ )
{
    int ans = solve(i, k) + solve(k + 1, j) + arr[i - 1] * arr[k] * arr[j];
    
    min = Math.min(min, ans);
}

=======================================================================================================

[10, 20, 30, 40, 50]
 0   1   2   3   4

(20, 50) => (20, 20) + (30, 50) + (10 * 20 * 50) => (30, 30) + (40, 50) + (20 * 30 * 50) + (10 * 20 * 50) => (40, 40) + (50, 50) + (30 * 40 * 50) + (20 * 30 * 50) + (10 * 20 * 50) => (30 * 40 * 50) + (20 * 30 * 50) + (10 * 20 * 50)
                 0                                       0                                                       0          0

                                                    (30, 40) + (50, 50) + (20 * 40 * 50) + (10 * 20 * 50) => (30, 30) + (40, 40) + (20 * 30 * 50) + (20 * 40 * 50) + (10 * 20 * 50) => (20 * 30 * 50) + (20 * 40 * 50) + (10 * 20 * 50)
                                                                   0                                             0          0
              
            (20, 30) + (40, 50) + (10 * 30 * 50) => (20, 20) + (30, 30) + (10 * 20 * 30) + (40, 50) + (10 * 30 * 50) 
                                                        0          0
                                                                                                          => (10 * 20 * 30) + (40, 40) + (50, 50) + (30 * 40 * 50) + (10 * 30 * 50) => (10 * 20 * 30) + (30 * 40 * 50) + (10 * 30 * 50)
                                                                                                                                  0          0         

            (20, 40) + (50, 50) + (10 * 40 * 50) => (20, 20) + (30, 40) + (10 * 20 * 40) + (10 * 40 * 50) => (30, 30) + (40, 40) + (20 * 30 * 40) + (10 * 20 * 40) + (10 * 40 * 50) => (20 * 30 * 40) + (10 * 20 * 40) + (10 * 40 * 50)
                             0                          0                                                        0          0

                                                    (20, 30) + (40, 40) + (10 * 30 * 40) + (10 * 40 * 50) => (20, 20) + (30, 30) + (10 * 20 * 30) + (10 * 30 * 40) + (10 * 40 * 50) => (10 * 20 * 30) + (10 * 30 * 40) + (10 * 40 * 50)
                                                                   0                                             0          0


So minimum would be calculated from 

(30 * 40 * 50) + (20 * 30 * 50) + (10 * 20 * 50)

(20 * 30 * 50) + (20 * 40 * 50) + (10 * 20 * 50)

(10 * 20 * 30) + (30 * 40 * 50) + (10 * 30 * 50)

(20 * 30 * 40) + (10 * 20 * 40) + (10 * 40 * 50)

(10 * 20 * 30) + (10 * 30 * 40) + (10 * 40 * 50)

So basically every combination 
======================================================================================================

*/