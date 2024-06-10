/* Problem - https://leetcode.com/problems/rotting-oranges/description/ 

https://takeuforward.org/data-structure/rotten-oranges-min-time-to-rot-all-oranges-bfs/

994. Rotting Oranges
Solved
Medium
Topics
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

*/

class Solution {

    public class Position {
        public int x;
        public int y;
        public int min;

        public Position(int x, int y, int c)
        {
            this.x = x;
            this.y = y;
            this.min = c;
        }
    }

    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[] X = { 1, 0, -1, 0 };
        int[] Y = { 0, 1, 0, -1 };

        int cnt = 0;
        int ans = 0;
        Queue<Position> queue = new LinkedList<>();

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    Position pos = new Position(i, j, 0);
                    queue.add(pos);
                }

                if(grid[i][j] == 1)
                {
                    ++cnt;
                }
            }
        }

        while(!queue.isEmpty())
        {
            Position currentPos = queue.poll();
            ans = Math.max(currentPos.min, ans);

            for(int i = 0; i < 4; i++)
            {
                int x = currentPos.x + X[i];
                int y = currentPos.y + Y[i];
                int min = currentPos.min;

                if( x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1 )
                {
                    grid[x][y] = 2;

                    queue.add(new Position(x, y, min + 1));
                    --cnt;
                }
            }
        }

        if(cnt == 0)
            return ans;
        else
            return -1;

    }
}