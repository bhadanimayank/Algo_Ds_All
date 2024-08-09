/* Problem - https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/

https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k

Given an array arr containing n integers and an integer k. Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value k.

Examples:
 
Input :
arr[] = {10, 5, 2, 7, 1, 9}, k = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
Input : 
arr[] = {-1, 2, 3}, k = 6
Output : 0
Explanation: 
There is no such sub-array with sum 6.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1<=n<=105
-105<=arr[i], K<=105

*/

class Solution{
    
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int a[], int n, int k)
    {
        Map<Integer, Integer> mapSum = new HashMap();
        
        int maxLen = 0;
        int sum = 0;
        
        for(int i = 0; i < n; i++)
        {
            sum = sum + a[i];
            
            if(sum == k)
            {
                maxLen = Math.max(maxLen, i + 1);
            }
            
            int rem = sum - k;
            
            if(mapSum.containsKey(rem))
            {
                int len = i - mapSum.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            
            if(!mapSum.containsKey(sum))
            {
                mapSum.put(sum, i);
            }
        }
        
        return maxLen;
    }
}


/* Notes

Understand the logic in two parts:

1) First is simple, if sum == k, then update maxLen

2) Second, suppose below is an array and the sum needs to be k = 5

        [3, 1, 2, 3]

        So suppose when i = 1, the sum 3 + 1 = 4

    So when we reach i = 3, 3 + 1 + 2 + 3 = 9,

    we check if there exists 9 - k = 9 - 5 = 4

    So if there exits 4 then the rest of the sum = 5 also exists that is sub-array [2, 3]

    So that is second part of logic

*/