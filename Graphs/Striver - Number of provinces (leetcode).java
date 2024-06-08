/* Problem - https://leetcode.com/problems/number-of-provinces/description/
https://takeuforward.org/data-structure/number-of-provinces/

547. Number of Provinces
Solved
Medium
Topics
Companies
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]

*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int m = isConnected.length;
        int n = isConnected[0].length;

        int ans = 0;

        boolean visited[] = new boolean[m];

        for( int i = 0; i < m; i++ )
        {
            if(!visited[i])
            {
                ans++;
                dfs(isConnected, visited, i);
            }
        }

        return ans;
    }

    public void dfs(int[][] grid, boolean[] visited, int i)
    {
        if(visited[i])
            return;

        visited[i] = true;

        for(int j = 0; j < grid[0].length; j++)
        {
            if(grid[i][j] == 1)
            {
                dfs(grid, visited, j);
            }
        }
    }
}

/* Notes

So grid represents m * m boxes representing 1 from one index to another

We initiate array visited to indicate whether we have visited certain rows on grid or not.

Basically what we are doing is we are iterating through rows, then inside the recursive functionwe are iterating through elements in those rows.
If we found element to be true, then we recursively go through the row indicated by column of that element and when visiting mark that row as visited.

*/