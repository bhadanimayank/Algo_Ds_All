/* Problem - https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/

https://leetcode.com/problems/sort-colors/description/

75. Sort Colors
Solved
Medium
Topics
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

*/

class Solution {
    public void sortColors(int[] nums) {
        
        int zeroFreq = 0;
        int firstFreq = 0;
        int secondFreq = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                ++zeroFreq;
            }
            else if(nums[i] == 1)
            {
                ++firstFreq;
            }
            else
            {
                ++secondFreq;
            }
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(zeroFreq > 0)
            {
                nums[i] = 0;
                --zeroFreq;
            }
            else if(firstFreq > 0)
            {
                nums[i] = 1;
                --firstFreq;
            }
            else
            {
                nums[i] = 2;
            }
        }  
    }
}


/* Notes

Count the frequency of elements and then fill accordingly in array.

*/