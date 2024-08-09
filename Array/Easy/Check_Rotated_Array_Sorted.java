/* Problem - https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/


Code
Code Sample
Code Sample
Testcase
Testcase
Test Result
1752. Check if Array Is Sorted and Rotated
Solved
Easy
Topics
Companies
Hint
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100


*/

// Approach 1

class Solution {
    public boolean check(int[] nums) {
        
        int n = nums.length;
        int rotation_start = 0;

        for(int i = 1; i < n; i++)
        {
            if(nums[i - 1] > nums[i])
            {
                rotation_start = i;
                break;
            }
        }

        int last = Integer.MIN_VALUE;

        for(int i = rotation_start; i < n; i++)
        {
            if(nums[i] >= last)
            {
                last = nums[i];
            }
            else
            {
                return false;
            }
        }

        last = nums[n - 1];

        for(int i = 0; i < rotation_start; i++)
        {
            if(nums[i] >= last)
            {
                last = nums[i];
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}

/* Notes

Find the Pivot point, check if array is sorted from pivot point to end of array, check if array is sorted from index 0 to elem prev to pivot point. 
During second step consider last array lement as last value.

*/


// Approach 2

class Solution {

    public boolean check(int[] nums) {
        
        int n = nums.length;
        int count = 0;

        for(int i = 1; i < n; i++)
        {
            if(nums[i - 1] > nums[i])
                ++count;
        }

        if(nums[0] < nums[n - 1])
            ++count;

        if(count > 1)
            return false;

        return true;
    }
}

/* Notes

So basically for any rotated non decreasing array, pivot point should only be one. Second thing is first element should be larer then the last element.

So counted the pivot point, if it's mre than 1, false should be returned.

For second point. Let's take an example [3 , 1 , 4 , 5]. It looks like pivoted. But it's not becasue 3 is less than 5. It should not be.

*/
