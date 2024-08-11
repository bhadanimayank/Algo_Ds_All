/* Problem - https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/

https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest

Given an array arr, return the second largest distinct element from an array. If the second largest element doesn't exist then return -1.

Examples:

Input: arr = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr = [10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist so answer is -1.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ arr.size() ≤ 105
1 ≤ arri ≤ 105



*/

class Solution {
    public int print2largest(List<Integer> arr) {
        // Code Here
        int max = arr.get(0);
        int sec_max = -1;
        
        for(int cur : arr)
        {
            if(cur > max)
            {
                sec_max = max;
                max = cur;
            }
            else if(cur < max && cur > sec_max)
            {
                sec_max = cur;
            }
        }
        
        return sec_max;
    }
}

/* Notes

So basically first if assigns the last max to secMax. The else if handles the condition if the current elment is lesser than the max but greater than the
second max then assign the current to second max.

*/

/* Revised

11-08-24 - Read Revised

*/