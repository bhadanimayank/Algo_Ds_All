/* Problem - https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=printing-longest-increasing-subsequence

https://takeuforward.org/data-structure/printing-longest-increasing-subsequence-dp-42/

Print Longest Increasing Subsequence
MediumAccuracy: 58.05%Submissions: 9K+Points: 4
Get Internship at GfG by submitting your Entries in: Data Science Blogathon

banner
Given an integer n and an array of integers arr, return the Longest Increasing Subsequence which is Index-wise lexicographically smallest.
Note - A subsequence S1 is Index-wise lexicographically smaller than a subsequence S2 if in the first position where S1 and S2 differ, subsequence S1 has an element that appears earlier in the array  arr than the corresponding element in S2.
LIS  of a given sequence is defined as that longest possible subsequence all of whose elements are in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and the LIS is {10, 22, 33, 50, 60, 80}. 

Example 1:

Input:
n = 16
arr = [0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15]
Output:
0 4 6 9 13 15 
Explanation:
longest Increasing subsequence is 0 4 6 9 13 15  and the length of the longest increasing subsequence is 6.
Example 2:

Input:
n = 1
arr = [1]
Output:
1
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestIncreasingSubsequence() which takes integer n and array arr and returns the longest increasing subsequence.

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n)

Constraint:
1 <= n < = 103
0 <= arr[i] <= 109

*/

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int[] hash = new int[n];
        Arrays.fill(hash, 1);
        
        for(int i = 0; i <= n - 1; i++)
        {
            hash[i] = i;
            for(int prevIndex = 0; prevIndex <= i - 1; prevIndex++ )
            {
                if( arr[prevIndex] < arr[i] && 1 + dp[prevIndex] > dp[i] )
                {
                    dp[i] = 1 + dp[prevIndex];
                    hash[i] = prevIndex;
                }
            }
        }
        
        int ans = -1;
        int last_Index = -1;
        
        for(int i = 0; i <= n - 1; i++)
        {
            if(dp[i]> ans)
            {
                ans = dp[i];
                last_Index = i;
            }
        }
        
        ArrayList<Integer> lis = new ArrayList<>();
        
        lis.add(arr[last_Index]);
        
        while(hash[last_Index] != last_Index)
        {
            last_Index = hash[last_Index];
            lis.add(0, arr[last_Index]);
        }
        
        return lis;
        
    }
}

// Notes

arr, dp = 
===============================================================================================

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
                                       ( arr[prevIndex] < arr[i] &&  1 + dp[prevIndex] > dp[i] )
int[] dp = new int[n];
Arrays.fill(dp, 1);

------------------------
| 1 | 1 | 1 | 1 | 1 | 1|    <-- dp
------------------------
  0   1   2   3   4   5                ( dp[i] = 1 + dp[prevIndex] )

------------------------
| 1 | 1 | 1 | 1 | 1 | 1|    <-- hash
------------------------
  0   1   2   3   4   5                ( hash[i] = i ) on first loop, ( hash[i] = prevIndex ) if conditon inside first loop is true

===============================================================================================

for(int i = 0; i <= n - 1; i++)
    {
        for(int prevIndex = 0; prevIndex <= i - 1; prevIndex++ )
        {
            if( arr[prevIndex] < arr[i] &&  1 + dp[prevIndex] > dp[i] )
            {
                dp[i] = 1 + dp[prevIndex];
            }
        }
    }

prev_Index = 0, i = 0

------------------------
| 0 | 1 | 1 | 1 | 1 | 1|    <-- hash
------------------------
  0   1   2   3   4   5               ( hash[0] = 0 )
  ^       
  p,i 

===============================================================================================

prev_Index = 0, i = 1

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr 
------------------------
  0   1   2   3   4   5
  ^   ^
  p   i                               ( arr[0] < arr[1] &&  1 + dp[0] > dp[1] ) : true

------------------------
| 1 | 2 | 1 | 1 | 1 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
  ^   ^
  p   i                               ( dp[1] = 1 + dp[0] ) : 2

------------------------
| 0 | 0 | 1 | 1 | 1 | 1|   <-- hash
------------------------
  0   1   2   3   4   5               ( hash[1] = 0 )
  ^   ^
  p   i   

===============================================================================================

prev_Index = 0, i = 2

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
  ^       ^
  p       i                           ( arr[0] < arr[2] &&  1 + dp[0] > dp[2] ) : true

------------------------
| 1 | 2 | 2 | 1 | 1 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
  ^       ^
  p       i                           ( dp[2] = 1 + dp[0] ) : 2

------------------------
| 0 | 0 | 0 | 1 | 1 | 1|    <-- hash
------------------------
  0   1   2   3   4   5               ( hash[2] = 0 )
  ^       ^
  p       i 

===============================================================================================

prev_Index = 1, i = 2

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
      ^   ^  
      p   i                           ( arr[1] < arr[2] &&  1 + dp[1] > dp[2] ) : false

------------------------
| 1 | 2 | 2 | 1 | 1 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
      ^   ^
      p   i

------------------------
| 0 | 0 | 0 | 1 | 1 | 1|    <-- hash
------------------------
  0   1   2   3   4   5              
      ^   ^
      p   i             

===============================================================================================

prev_Index = 0, i = 3

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
  ^           ^  
  p           i                       ( arr[0] < arr[3] &&  1 + dp[0] > dp[3] ) : true

------------------------
| 1 | 2 | 2 | 2 | 1 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
  ^           ^
  p           i                       ( dp[3] = 1 + dp[0] ) : 2

------------------------
| 0 | 0 | 0 | 0 | 1 | 1|    <-- hash
------------------------
  0   1   2   3   4   5               ( hash[3] = 0 )
  ^           ^
  p           i   

===============================================================================================

prev_Index = 1, i = 3

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
      ^       ^  
      p       i                       ( arr[1] < arr[3] &&  1 + dp[1] > dp[3] ) : false

------------------------
| 1 | 2 | 2 | 2 | 1 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
      ^       ^
      p       i                   

------------------------
| 0 | 0 | 0 | 0 | 1 | 1|   <-- hash
------------------------
  0   1   2   3   4   5               
      ^       ^
      p       i            

===============================================================================================

prev_Index = 2, i = 3

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
          ^   ^  
          p   i                       ( arr[2] < arr[3] &&  1 + dp[2] > dp[3] ) : true

------------------------
| 1 | 2 | 2 | 3 | 1 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
          ^   ^
          p   i                       ( dp[3] = 1 + dp[2] ) : 3

------------------------
| 0 | 0 | 0 | 2 | 1 | 1|    <-- hash
------------------------
  0   1   2   3   4   5               ( hash[3] = 2 )    
          ^   ^
          p   i

===============================================================================================

prev_Index = 0, i = 4

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
  ^               ^  
  p               i                    ( arr[0] < arr[4] &&  1 + dp[0] > dp[4] ) : true

------------------------
| 1 | 2 | 2 | 3 | 2 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
  ^               ^
  p               i                    ( dp[4] = 1 + dp[0] ) : 2

------------------------
| 0 | 0 | 0 | 2 | 0 | 1|    <-- hash
------------------------
  0   1   2   3   4   5                ( hash[4] = 0 ) 
  ^               ^
  p               i 

===============================================================================================

prev_Index = 1, i = 4

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
      ^           ^  
      p           i                    ( arr[1] < arr[4] &&  1 + dp[1] > dp[4] ) : false

------------------------
| 1 | 2 | 2 | 3 | 2 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
      ^           ^
      p           i               

------------------------
| 0 | 0 | 0 | 2 | 0 | 1|    <-- hash
------------------------
  0   1   2   3   4   5      
      ^           ^
      p           i                    
 
===============================================================================================

prev_Index = 2, i = 4

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
          ^       ^  
          p       i                    ( arr[2] < arr[4] &&  1 + dp[2] > dp[4] ) : true

------------------------
| 1 | 2 | 2 | 3 | 3 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
          ^       ^
          p       i                    ( dp[4] = 1 + dp[2] ) : 3

------------------------
| 0 | 0 | 0 | 2 | 2 | 1|    <-- hash
------------------------
  0   1   2   3   4   5                ( hash[4] = 2 )    
          ^       ^
          p       i
 
===============================================================================================

prev_Index = 3, i = 4

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
              ^   ^  
              p   i                    ( arr[3] < arr[4] &&  1 + dp[3] > dp[4] ) : false

------------------------
| 1 | 2 | 2 | 3 | 3 | 1|    <-- dp
------------------------
  0   1   2   3   4   5
              ^   ^
              p   i        

------------------------
| 0 | 0 | 0 | 2 | 2 | 1|     <-- hash
------------------------
  0   1   2   3   4   5         
              ^   ^
              p   i                   ( hash[4] = 4 )   
 
===============================================================================================

prev_Index = 0, i = 5

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
  ^                   ^  
  p                   i                ( arr[0] < arr[5] &&  1 + dp[0] > dp[5] ) : true

------------------------
| 1 | 2 | 2 | 3 | 3 | 2|    <-- dp
------------------------
  0   1   2   3   4   5
  ^                   ^  
  p                   i                ( dp[5] = 1 + dp[0] ) : 2

------------------------
| 0 | 0 | 0 | 2 | 2 | 0|   <-- hash
------------------------
  0   1   2   3   4   5                ( hash[5] = 0 )   
  ^                   ^  
  p                   i 
 
===============================================================================================

prev_Index = 1, i = 5

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
      ^               ^  
      p               i                ( arr[1] < arr[5] &&  1 + dp[1] > dp[5] ) : false

------------------------
| 1 | 2 | 2 | 3 | 3 | 2|    <-- dp
------------------------
  0   1   2   3   4   5
      ^               ^  
      p               i     

------------------------
| 0 | 0 | 0 | 2 | 2 | 0|   <-- hash
------------------------
  0   1   2   3   4   5       
      ^               ^  
      p               i                   
  
===============================================================================================

prev_Index = 2, i = 5

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
          ^           ^  
          p           i                ( arr[2] < arr[5] &&  1 + dp[2] > dp[5] ) : true

------------------------
| 1 | 2 | 2 | 3 | 3 | 3|    <-- dp
------------------------
  0   1   2   3   4   5
          ^           ^  
          p           i               ( dp[5] = 1 + dp[2] ) : 3

------------------------
| 0 | 0 | 0 | 2 | 2 | 2|   <-- hash
------------------------
  0   1   2   3   4   5               ( hash[5] = 2 )  
          ^           ^  
          p           i 
  
===============================================================================================

prev_Index = 3, i = 5

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
              ^       ^  
              p       i                ( arr[3] < arr[5] &&  1 + dp[3] > dp[5] ) : false

------------------------
| 1 | 2 | 2 | 3 | 3 | 3|    <-- dp
------------------------
  0   1   2   3   4   5
              ^       ^  
              p       i                

------------------------
| 0 | 0 | 0 | 2 | 2 | 2|    <-- hash
------------------------
  0   1   2   3   4   5       
              ^       ^  
              p       i              
===============================================================================================
prev_Index = 4, i = 5

------------------------
| 1 | 6 | 2 | 5 | 3 | 4|    <-- arr
------------------------
  0   1   2   3   4   5
                  ^   ^  
                  p   i                ( arr[4] < arr[5] &&  1 + dp[4] > dp[5] ) : true

------------------------
| 1 | 2 | 2 | 3 | 3 | 4|    <-- dp
------------------------
  0   1   2   3   4   5
                  ^   ^  
                  p   i                ( dp[5] = 1 + dp[4] ) : 4

------------------------
| 0 | 0 | 0 | 2 | 2 | 4|   <-- hash
------------------------
  0   1   2   3   4   5                ( hash[5] = 4 )  
                  ^   ^  
                  p   i 
  
===============================================================================================

for(int i = 0; i <= n - 1; i++)
{
    if(dp[i]> ans)
    {
        ans = dp[i];
        last_Index = i;
    }
}


last_Index = 5

while(hash[last_Index] != last_Index)
{
    last_Index = hash[last_Index];
    lis.add(0, arr[last_Index]);
}

------------------------------------
Indexes ->  5  ->  4  ->  2  ->  0 |
------------------------------------
LIS     ->  4  ->  3  ->  2  ->  1 |
------------------------------------
          
/* Explaination

-> Second loop is run till n - 1 becasue prev elemnt will always be less then currect elem
-> It's like moving windows technique, so every time second loop runs from 0 ... i. then 0 ... i + 1, then 0 ... i + 2 till 0 ... n - 1.
-> So every time second loop runs for i + 1 or till next elem, next elemnet is compared to all prev element if it's bigger then prev_element, 
   dp is  dp[prev] + 1
-> So suppose there is an array [3, 4, 5] and initial dp is [1, 1, 1] because in itself every elemnet is minimal LIS. So at first loop 3 is compare to 4
   so dp now is [1, 2, 1]. Nw a second loop 3 is compared to 5, Now dp would be [1, 2, 2]. Now 4 is compared to 5. So dp will be [1, 2, 3]
   That's the intution, every new element i + 1 getting compared to prev elemnts, if it's larger it will increment it's dp by 1 from dp of prev element.
-> Also the i + 1 dp must be equal to or less then prev elem dp, or it will not be incremented because currently i + 1 dp is already indicating longer LIS
   then the prev Element.
-> So to understand last point consider an array [3, 4, 1, 5] and dp is [1, 2, 1, 3] till element 4 is compared to 5, now compare elemt 1 to 5.
   Here 5 is bigger to 1. But dp for 5 is already indicating at longer LIS. So dp for 5 will not be incremented.
-> Now we can understand how hash is indicating the longest LIS. So we can understand that dp only gets incremented if it's going to indicate longest LIS 
   by comparing it to prev element. and that prev element is compared to it's prev element when t's dp was incremented. So every time dp is getting
   incremented, we can store the prev_index in the hash, now iteratively the next dp increment will have the current element as prev_index.
   So it's make a chain of prev indexes. Now we are doing hash[i] = i for every first loop.
   So where hash[i] = i that means it does not have any prev element as it was not updated in second loop. So when we print LIS, we an stop when 
   hash[i] = i.  

*/
