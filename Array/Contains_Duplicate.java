/*

Contains Duplicate : Check if a value appears atleast twice


33

1
Problem Statement: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example:

Example 1:
Input: nums = [1, 2, 3, 1]
Output: true.
Explanation: 1 appeared two times in the input array.

Example 2: 
Input: nums = [1, 2, 3, 4]
Output: false
Explanation: input array does not contain any duplicate number. 

*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> set = new HashSet();
        int len = nums.length;

        for(int i = 0; i < len; i++)
        {
            if(set.contains(nums[i]))
            {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
        
    }
}