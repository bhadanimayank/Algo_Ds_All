/* Problem - https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/

https://leetcode.com/problems/majority-element/description/


Code
Testcase
Testcase
Test Result
169. Majority Element
Solved
Easy
Topics
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?


*/

class Solution {
    public int majorityElement(int[] nums) {

       Map<Integer, Integer> map = new HashMap<>();

        int current;
        int freq;

        for(int i = 0; i < nums.length; i++)
        {
            current = nums[i];
            freq = 0;
            if(map.containsKey(current))
            {
                freq = map.get(current);
                ++freq;

                if(freq > nums.length/2)
                {
                    return current;
                }

                map.put(current, freq);
            }
            else
            {
                freq = 1;
                map.put(current, freq);

                if(freq > nums.length/2)
                {
                    return current;
                }
            }
        }
        
        return 0;
    }
}


/* Notes

Straight Forward - store freq of elmenets in HashMap and keep checking if any freq is > n/2

*/