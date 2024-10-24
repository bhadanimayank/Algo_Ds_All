// https://leetcode.com/problems/product-of-array-except-self/

/*

238. Product of Array Except Self
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

*/


class Solution
{
    public int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;

        for(int i = 1; i < n; i++)
        {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        for(int i = n - 2; i >= 0; --i)
        {
            suffix[i] = nums[i + 1] * suffix[i + 1];
        }

        for(int i = 0; i < n; i++)
        {
            nums[i] = prefix[i] * suffix[i];
        }

        return nums;
    }
}

/*

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

- Consider element 2 => So the multiple will be 1 * 3 * 4 = 12, So it will be product of prefix [1] and suffix [3, 4].

So, we need to create a prefix array. So each index at prefix array will contain multiple of elements at previous indexes of nums array.

Similarly, we need to create a suffix array. So each index at suffix array will contain multiple of elements at later indexes of nums array. 

Now for each index we need to multiply elements at prefix and suffix array.

*/