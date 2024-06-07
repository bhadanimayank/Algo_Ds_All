/* Problem - https://takeuforward.org/graph/introduction-to-graph/

https://www.geeksforgeeks.org/problems/graph-and-vertices/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=graph-and-vertices

Your Task:

Complete the function count() which takes an integer n as input and return the count of total number of graphs possible. 

Expected Time Complexity: O(1)

Expected Space Complexity: O(1)

Constraints:

1<=n<=10

*/


class Solution {
    static long count(int n) {
    // code here
    
    // total number of edges
    
    int t = (n * ( n - 1 )) / 2;
    
    // So every edge can have two choices of being selected or not. so total number of possibilities 2 ^ t
    
    return (long)Math.pow(2, t);

  }
}
