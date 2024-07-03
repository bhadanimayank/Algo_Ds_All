/* Problem - https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

https://takeuforward.org/data-structure/g-36-shortest-distance-in-a-binary-maze/

1091. Shortest Path in Binary Matrix
Solved
Medium
Topics
Companies
Hint
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1

*/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1)
            return -1;

        int dist[][] = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 1;

        Queue<Location> queue = new LinkedList<Location>();
        queue.add(new Location(0, 0));

        int[] x = { -1, -1, -1 ,  0, 0,  1, 1, 1};
        int[] y = { -1,  0,  1 , -1, 1, -1, 0, 1};

        while(!queue.isEmpty())
        {
            Location current = queue.poll();

            for(int i = 0; i <= 7; i++)
            {
                int a = current.i + x[i];
                int b = current.j + y[i];

                if( a < m && a >= 0 && b < n && b >= 0 && grid[a][b] == 0 )
                {
                    if( dist[current.i][current.j] + 1 < dist[a][b] )
                    {
                        dist[a][b] = dist[current.i][current.j] + 1;
                        queue.add(new Location(a, b));
                    }
                }
            }

        }

        return dist[m - 1][n - 1] == Integer.MAX_VALUE ? -1: dist[m - 1][n - 1];

    }

    public class Location {
        public int i;
        public int j;

        public Location(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

/* Notes

Straight Forward BFS

*/