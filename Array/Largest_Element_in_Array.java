/* Problem - Largest Element in Array

Given an array arr, the task is to find the largest element in it.
Examples:

Input: arr= [1, 8, 7, 56, 90]
Output: 90
Explanation: The largest element of given array is 90.
Input: arr = [5, 5, 5, 5]
Output: 5
Explanation: The largest element of given array is 5.
Input: arr = [10]
Output: 10
Explanation: There is only one element which is the largest
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size()<= 105
0 <= arri <= 105
arr may contain duplicate elements.


*/

class Solution {
    public static int largest(int n, int[] arr) {
        // code here
        
        int val = Integer.MIN_VALUE;
        
        for(int cur : arr)
        {
            if(cur > val)
            {
                val = cur;
            }
        }
        
        return val;
    }
}
