/* Problem - https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/

https://leetcode.com/problems/maximum-subarray/


53. Maximum Subarray
Solved
Medium
Topics
Companies
Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        int curSum = 0;
        int maxSum = nums[0];

        for(int i : nums)
        {
            curSum += i;

            maxSum = Math.max(curSum, maxSum);

            if(curSum < 0)
            {
                curSum = 0;
            }
        }

        System.gc();
        return maxSum;
    }
}

/* Notes

So consider the elements being added to curSum. So if the element is positive it increases the curSum value, if it's a negative element then curSum value will be
decreased.

So each time a element is added we will set the maxiumum value achieved in maxSum having the end result.

But if the curSum value dips below zero, we are going to reset the value. Basically meaning starting the summation  from next element.

*/