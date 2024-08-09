/* Problem - https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/

https://leetcode.com/problems/single-number/description/

136. Single Number
Solved
Easy
Topics
Companies
Hint
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.


*/


class Solution {
    public int singleNumber(int[] nums) {

        int res = 0;

        for(int num: nums)
        {
            res ^= num;
        }

        System.gc();

        return res;
        
    }
}

/* Notes

Xor Operator when a ^ a = 0 and a ^ 0 = a, So when a number appear twice and when xor it will be 0, when a the single appearing integer xor with 0,
it will be that integer as answer.

*/