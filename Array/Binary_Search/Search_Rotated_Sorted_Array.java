// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

// https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/

/*

33. Search in Rotated Sorted Array
Medium
Topics
Companies
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

*/

// Java ==========================================================================================================

class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high)
        {
            int mid = (low + high)/2;

            if(nums[mid] == target)
                return mid;

            if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && target < nums[mid])
                {
                    high = mid - 1;
                }   
                else
                {
                    low = mid + 1;
                }             
            }
            else
            {
                if(nums[mid] < target && target <= nums[high])
                {
                    low = mid + 1;

                }
                else
                {
                    high = mid - 1;
                }            
            }
        }

        return -1;
    }
}

// C# ============================================================================================================

public class Solution {
    public int Search(int[] nums, int target) {

        int low = 0;    
        int high = nums.Length - 1;

        while(low <= high)
        {
            int mid = (high + low) / 2;

            if(nums[mid] == target)
            {
                return mid;
            }

            if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && target < nums[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else
            {
                if(nums[mid] < target && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }

        return -1;

    }
}

/* Notes ==========================================================================================================

Ex:  Suppose we have below pivoted array:

    [4, 5, 6, 7, 8, 9, 1, 2, 3]
                 ↑
     0  1  2  3  4  5  6  7  8

So 8 at index 4 is at the middle. So before the middle array is sorted correctly. So from whichever index you pivot one side of the array from middle
Will be correctly sorted and other half will be pivoted.

-> So while logic is purely Binary Seacrh, the first if level decides which half have the array sorted correctly.

We search if the target element exists in the corrctly sorted part. if yes we set that part of array as search space as next iteration.

If we do not find the target in the sorted part, we set the other half to be the serach space for next iteration

Go forward with next iteration.
        

*/