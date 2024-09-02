/* Problem - https://leetcode.com/problems/majority-element-ii/description/

https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/


Code
Code Sample
Code Sample
Testcase
Testcase
Test Result
229. Majority Element II
Solved
Medium
Topics
Companies
Hint
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?

*/

// Solution 1

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        int n = nums.length;
        int threshold = n/3;

        for(int num: nums)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: counts.entrySet())
        {
            if(entry.getValue() > threshold)
            {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}

/* Notes - Solution 1

Create a HashMap storing array element as Key and its count as value.
Iterate the array and check and store the value and count in HashMap

Iterate the Hashmap, check count greater than threshold and store the elements in answer list.

*/

// Solution 2 - Boyer Moore’s Voting Algorithm

class Solution {

    public List<Integer> majorityElement(int[] nums) {

        int elm1 = Integer.MIN_VALUE, elm2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;

        int threshold = nums.length/3;

        for(int num: nums)
        {
            if(cnt1 == 0 && num != elm2)
            {
                ++cnt1;
                elm1 = num;
            }
            else if(cnt2 == 0 && num != elm1)
            {
                ++cnt2;
                elm2 = num;
            }
            else if(elm1 == num)
            {
                ++cnt1;
            }
            else if(elm2 == num)
            {
                ++cnt2;
            }
            else
            {
                --cnt1;
                --cnt2;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for(int num: nums)
        {
            if(num == elm1)
                ++cnt1;

            if(num == elm2)
                ++cnt2;
        }

        List<Integer> ans = new ArrayList<>();
        
        if(cnt1 > threshold)
        {
            ans.add(elm1);
        }

        if(cnt2 > threshold)
        {
            ans.add(elm2);
        }

        return ans;
        
    }
}

/* Notes - Solution 2 - Boyer Moore’s Voting Algorithm

So First thing to notice if we have an array of length N. We need to find the elements which appear more than N/3 times.

so there could be no elements present such as that. Also, there could be at max 2 such elements could be present

(N/3 + a) + (N/3 + b) + c = N

c = (N - N/3 - N/3) - a - b;

c = N/3 - a - b;

So, third element appearance would always be less than N/3

=======================================================================================================================================================

Now explaining Boyer Moore’s Voting Algorithm.

We declare elm1 and elm2 to record 2 elements with most frequency.
We correspondingly declare cnt1 and cnt2 to note the frequency.

So basically what we do we start with first 2 unique elemets in array and assign it to elm1 and elm2

if we again encounter those elements we increment cnt1 and cnt2

If we encounter any other elements then decrease cnt1 and cnt2

if cnt1 or cnt2 equals 0, then assign the next element to elm1 or elm2.

finally elm1 and elm2 will hold elements with maximum frequency

then again iterate the array to count the total frequency of elm1 and elm2

compare both with threshold frequency and add to the answer list and return the same.

*/