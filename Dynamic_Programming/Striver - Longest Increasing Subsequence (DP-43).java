/* Problem - https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-increasing-subsequence

https://takeuforward.org/data-structure/longest-increasing-subsequence-binary-search-dp-43/

Given an array a[ ] of n integers, find the Length of the Longest Strictly Increasing Subsequence.

A sequence of numbers is called "strictly increasing" when each term in the sequence is smaller than the term that comes after it.

Example 1:

Input:
n = 6,
a[ ] = {5,8,3,7,9,1}
Output: 
3
Explanation:
There are more than one LIS in this array.  
One such Longest increasing subsequence is {5,7,9}.
Example 2:

Input:
n = 16,
a[ ] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output: 
6
Explanation:
There are more than one LIS in this array. 
One such Longest increasing subsequence is {0,2,6,9,13,15}.
Your Task:
You do not need to read input or print anything. Complete the function longestSubsequence() which takes the given array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( n*log(n) )
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 104
0 ≤ a[i] ≤ 106

*/

class Solution {
    
    
    /*
    static int longestSubsequence(int n, int a[]) {
        
        int dp[][] = new int[n][n + 1];
        
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return solve(a, dp, n - 1, 0, -1);
    }
    
    static int solve(int[] arr, int[][] dp, int n, int i, int prevIndex)
    {
        if(i > n)
        {
            return 0;
        }
        
        if(prevIndex != -1 && dp[i][prevIndex + 1] != -1)
            return dp[i][prevIndex + 1];
        
        int take = 0;
        
        if( prevIndex == -1 || arr[prevIndex] < arr[i] )
        {
            take = 1 + solve( arr, dp, n, i + 1, i );
        }
        
        int nonTake = solve( arr, dp, n, i + 1, prevIndex );
        
        return dp[i][prevIndex + 1] = Math.max(take, nonTake);
    }
    */
    
    /*
    static int longestSubsequence(int n, int arr[]) {
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for( int i = 0; i < n; i++ )
        {
            for( int prev_Index = 0; prev_Index < i; prev_Index++ )
            {
                if( arr[i] > arr[prev_Index] && dp[i] < dp[prev_Index] + 1 )
                {
                    dp[i] = dp[prev_Index] + 1;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int val: dp)
        {
            if( max < val )
            {
                max = val;
            }
        }
        
        return max;
        
    }
    */
    
    static int longestSubsequence(int n, int arr[]) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        list.add(arr[0]);
        
        for(int i = 1; i < n; i++)
        {
            if( arr[i] > list.get(list.size() - 1) )
            {
                list.add(arr[i]);
            }
            else
            {
                int loc = Collections.binarySearch(list, arr[i]);
                
                if(loc < 0)
                    loc = - loc - 1;
                
                list.set(loc, arr[i]);
            }
        }
        
        return list.size();
        
    }
    
    
}

// Notes

So here the logic is to not the store the LIS in the final ans ArrayList. It will have a totally different string at the end, But to get the length of the LIS possible
in the problem array

So what we are going to do is we are goint o initialize below ArrayList

ArrayList<Integer> list = new ArrayList<Integer>();

Also we are going to add first element from array to ArrayList

list.add(arr[0]);

now the logic we are going to build is we are going to iterate given array from i = 1 and if the element is greater than the last element in ArrayList we are going to
add it at the end of the list

list.add(arr[i]);

if it's lesser then we are going to binary search the arraylist and find the index of next greater element in the array then the arr[i] and replace the next greater
element with arr[i]

and at the end of iteration at n, we are going to find the size of ArrayList.

Now let's run one example

========================================
i = 0

arr = [5, 6, 7, 8, 1, 2, 3, 9]
       ^
       |
       0  1  2  3  4  5  6  7

list = [5]

========================================
i = 1

arr = [5, 6, 7, 8, 1, 2, 3, 9, 4]
          ^
          |
       0  1  2  3  4  5  6  7  8

list = [5, 6]

========================================
i = 2

arr = [5, 6, 7, 8, 1, 2, 3, 9, 4]
             ^
             |
       0  1  2  3  4  5  6  7  8

list = [5, 6, 7]

========================================
i = 3

arr = [5, 6, 7, 8, 1, 2, 3, 9, 4]
                ^
                |
       0  1  2  3  4  5  6  7  8

list = [5, 6, 7, 8]

========================================
i = 4

arr = [5, 6, 7, 8, 1, 2, 3, 9, 4]
                   ^
                   |
       0  1  2  3  4  5  6  7  8

list = [1, 6, 7, 8]

========================================
i = 5

arr = [5, 6, 7, 8, 1, 2, 3, 9, 4]
                      ^
                      |
       0  1  2  3  4  5  6  7  8

list = [1, 2, 7, 8]
========================================
i = 6

arr = [5, 6, 7, 8, 1, 2, 3, 9, 4]
                         ^
                         |
       0  1  2  3  4  5  6  7  8

list = [1, 2, 3, 8]
========================================
i = 7

arr = [5, 6, 7, 8, 1, 2, 3, 9, 4]
                            ^
                            |
       0  1  2  3  4  5  6  7  8

list = [1, 2, 3, 8, 9]
========================================
i = 8

arr = [5, 6, 7, 8, 1, 2, 3, 9, 4]
                               ^
                               |
       0  1  2  3  4  5  6  7  8

list = [1, 2, 3, 4, 9]
========================================

so size of list is 5 which is the answer but lis is [5, 6, 7, 8, 9]

The logic here is if we are constructing list array and we encounter a smaller elements in between whether continuos or non-continuous we try to
insert the same in the list, if those smaller elements leads to a longer LIS then comparitively larger elments. It's going to replace the larger array element 
one by one in the current list.

If the smaller elements are not going to lead to a larger LIS, but a small LIS, it will replace some elements from the left side of the array. So some elements 
will be replaced but length of list will not change.

and supppose we encounter elemnets at the end which are bigger then all elemnts it's going to be appended at the end, if other wise if we encounter smaller elements
it will replcae existing element from left side of the array.



