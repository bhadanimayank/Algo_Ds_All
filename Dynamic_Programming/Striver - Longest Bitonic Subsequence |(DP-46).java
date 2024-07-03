/* Problem - https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1

https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/

Longest Bitonic subsequence
MediumAccuracy: 47.34%Submissions: 61K+Points: 4
Skill-Up Summer Sale! Get 30% Off on all GfG Courses.
Get Certified this Summer!

banner
Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
 

Example 1:

Input: 
n = 5
nums = [1, 2, 5, 3, 2]
Output: 
5
Explanation: 
The sequence {1, 2, 5} is
increasing and the sequence {3, 2} is 
decreasing so merging both we will get 
length 5.
Example 2:

Input: 
n = 8
nums = [1, 11, 2, 10, 4, 5, 2, 1]
Output: 
6
Explanation: 
The bitonic sequence 
{1, 2, 10, 4, 2, 1} has length 6.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function LongestBitonicSequence() which takes the array nums[] as input parameter and returns the maximum length of bitonic subsequence.
 

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n)
 

Constraints:
1 ≤ length of array ≤ 103
1 ≤ arr[i] ≤ 104

*/


class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int[] dp1 = new int[n];   // increasing dp1
        Arrays.fill(dp1, 1);
        
        int[] dp2 = new int[n];   // decreasing dp2
        Arrays.fill(dp2, 1);
        
        for( int i = 0; i < n; i++ )
        {
            for( int prev_i = 0; prev_i < i; prev_i++ )
            {
                if( nums[i] > nums[prev_i] && dp1[i] < dp1[prev_i] + 1 )
                {
                    dp1[i] = dp1[prev_i] + 1;
                }
            }
        }
        
        for( int i = n - 1; i >= 0; i-- )
        {
            for( int prev_i = n - 1; prev_i > i; prev_i-- )
            {
                if( nums[i] > nums[prev_i] && dp2[i] < dp2[prev_i] + 1 )
                {
                    dp2[i] = dp2[prev_i] + 1;
                } 
            }
        }
        
        int maxi = 0;
        
        for( int i = 0; i < n; i++ )
        {
            if( dp1[i] > 1 && dp2[i] > 1 )
            {
                maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
            }
        }
        
        return maxi;
    }
}

/* Notes

1) Build two dp array, dp1 should have LIS data normally and dp2 should have LIS data build by reading input array in reverse order


2) Calculate the bitonic sequence by finding the largest sum of elemnts of two dp arrays. -1 should be done to deduct the common point

3) Wherever id the maximum points at index should indicting longest increasing order from left and largest increasing order from right side and at comon index they both meet.

*/