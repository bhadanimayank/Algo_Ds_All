/* Problem - https://takeuforward.org/data-structure/left-rotate-the-array-by-one/ 

https://leetcode.com/problems/rotate-array/description/

189. Rotate Array
Medium
Topics
Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

*/


// Approach1 - Time Limit Exceeded

class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;

        for(int i = 0; i < k; i++)
        {
            int temp = nums[n - 1];
            for(int j = n - 1; j > 0; j--)
            {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}

/* Notes

just moved the array elements 1 position

*/


// Approach2

class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;

        if(k > n)
            k = k % n;

        int[] temp = new int[k];

        for(int i = 0; i < k; i++)
        {
            temp[i] = nums[(n - k) + i];
        }
        
        for(int j = n - 1; j > k - 1; j--)
        {
            nums[j] = nums[j - k];
        }

        for(int i = 0; i < k; i++)
        {
            nums[i] = temp[i];
        }
    }
}


/* Notes

Copy the k elements from end of the array to the new array. move the elements k positions. Now copy the elements from the temp array to start of the array.

*/