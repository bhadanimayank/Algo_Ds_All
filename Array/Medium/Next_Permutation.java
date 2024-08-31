/* Problem - https://leetcode.com/problems/next-permutation/description/

https://leetcode.com/problems/next-permutation/description/

31. Next Permutation
Solved
Medium
Topics
Companies
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

*/

class Solution {
    public void nextPermutation(int[] nums)
    {
        int ind = -1;
        int len = nums.length - 2;

        for(int i = len; i >= 0; --i)
        {
            if(nums[i] < nums[i + 1])
            {
                ind = i;
                break;
            }
        }

        if(ind == -1)
        {
            reverse(nums, 0);
            return;
        }

        for(int i = nums.length - 1; i > ind; --i)
        {
            if(nums[i] > nums[ind])
            {
                swap(nums, i, ind);
                break;
            }
        }

        reverse(nums, ind + 1);
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start)
    {
        int i = start;
        int j = nums.length - 1;

        while(i < j)
        {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

/* Notes

Consider below example

1) -> [1, 2, 3]
          ↓
2) -> [1, 3, 2]
          ↓
3) -> [2, 1, 3]
          ↓
4) -> [2, 3, 1]
          ↓
5) -> [3, 1, 2]
          ↓
6) -> [3, 2, 1]

Solution below:

1) Find the Breakpoint :

Scan Array from last index to start index and find where nums[i] < nums[i + 1] and store the index i value in ind

        int ind = -1;
        int len = nums.length - 2;

        for(int i = len; i >= 0; --i)
        {
            if(nums[i] < nums[i + 1])
            {
                ind = i;
                break;
            }
        }

        For Example take array [2, 3, 1]
                                0  1  2

        So breakppoint will be value 2 at index 0
                                
                                 
2) If the array is in decreasing order or non-increasing order, or there is no such breakpoint present as defined in 1st point, then reverse the array

Like in the example given going from step 6 to step 1

        if(ind == -1)
        {
            reverse(nums, 0);
            return;
        }


3) If the breakpoint is found which is suppose at index i where it is less than value at i + 1
    
    a) Then swap the value at index i with the value at indexes greater than i from i + 1 to n
    b) But which value to replace with, the value should be greater than value at i, but should be smallest one among values from i + 1 to n
    c) IMPORTANT thing to notice, when you were searching for breakpoint you already iterated through among the values from last index of array where nums[i] > nums[i + 1]
    d) So again you have to iterate from last index array But you only have to find the value which is greater than val[i]

        for(int i = nums.length - 1; i > ind; --i)
        {
            if(nums[i] > nums[ind])
            {
                swap(nums, i, ind);
                break;
            }
        }

        

        again continuing the example array [2, 3, 1] breakppoint was value 2 at index 0
                                            0  1  2

        so we start iterating from emd of the array 1 is smaller then 2 and next greater value is 3. So Swap 2 with 3

        So resulting array will be [3, 2, 1]
                                    0  1  2


4) Then you have to reverse the array from index i + 1 to n

   Continuing above example array [3, 2, 1]
                                   0  1  2

   We have to reverse array from i + 1 to n which s from index 1 to 2

   So next greater permutaion will be  [3, 1, 2]
                                        0  1  2

*/