/* Problem - https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/

https://www.naukri.com/code360/problems/maximum-subarray_893296?count=25&page=1&search=&sort_entity=order&sort_order=ASC&leftPanelTabValue=SUBMISSION

Problem statement
Ninjas has been given an array. He wants to find a subarray such that the sum of all elements in the subarray is maximum.

Subarray 'A' is greater than sub-array 'B' if sum(A) > sum(B). If two sub-array have the same maximum sum, then output the subarray that has a larger length.

A subarray means a contiguous part of an array. For example, In 'arr' = [1, 2, 3, 4], [1, 2], [2, 3, 4] are the contiguous subarry but [1, 3, 4] is not a subarray.

Note:

More than one sub-array can have a maximum sum, in that case, output any.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
1 <= N <= 1000
-99 <= |arr| <= 99

Time limit: 1 sec.
Sample Input 1:
2
6
1 2 5 -7 2 3
4
-2 -3 -4 1
Sample Output 1:
1
1    
Explanation Of Sample Input 1:
Test case 1:
For the first test case of sample output 1, as we start traveling the array, the summation of the first 3 elements counts to 8 but if add the rest of the elements, our sum decreases on reaching the end. Hence our maximum subarray will be [ 1, 2, 5 ]. 

Test case 2:   
For the second test case of sample output 1, as we start traveling the array, we find that our maximum subarray would contain only the last element as the rest of the elements make the sum negative. Hence our maximum subarray will be [1].
Sample Input 2:
2
7
-3 1 2 3 -4 6 -9
4
-4 -3 -2 -1
Sample Output 2:
1 
1
Explanation Of Sample Input 2:
Test case 1:
For the first test case of sample output 2, we would consider the subarray [ 1, 2, 3, -4, 6].

Test case 2:   
For the second test case of sample output 2, as we start traveling the array, we find that all the numbers in the array are negative. So, our maximum sum subarray is [-1]

*/

import java.util.* ;
import java.io.*; 

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> maximumsumSubarray(int n, int arr[]) {
		// Write your code here

		int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
		int si = 0;
		int ei = 0;
		int k = 0;

        for(int j = 0; j < n; j++)
        {
            curSum += arr[j];

			if(curSum > maxSum)
			{
				maxSum = curSum;
				si = k;
				ei = j;
			}

            if(curSum < 0)
            {
                curSum = 0;
				k = j + 1;
            }
        }

		ArrayList<Integer> result = new ArrayList<Integer>();

		for(int j = si; j <= ei; j++)
		{
			result.add(arr[j]);
		}

        return result;
	}
}


/* Notes

Read kadane solution notes for max sum here bhadanimayank/Algo_Ds_All/Array/Medium/Maximum_Subarray_Kadane.java

Now to extend the above solution, we set two indexes starting Index and end Index and keep updating it on the conditions.
if maxSum gets updated, update the endIndex and startIndex with last time when starting index was reset

*/