/* Problem - https://leetcode.com/problems/path-with-minimum-effort/description/

https://takeuforward.org/data-structure/g-37-path-with-minimum-effort/


1631. Path With Minimum Effort
Solved
Medium
Topics
Companies
Hint
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106

*/

class Solution {

    class Pair{
        int i;
        int j;
        int effort;

        public Pair(int x, int y, int effort)
        {
            this.i = x;
            this.j = y;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;

        int dist[][] = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.effort - y.effort);

        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        int[] dx = {-1, 0, 1,  0};
        int[] dy = { 0, 1 ,0, -1};

        while(pq.size() != 0)
        {
            Pair current = pq.poll();

            int effort = current.effort;
            int i = current.i;
            int j = current.j;

            if(i == m - 1 && j == n- 1)
                return effort;

            for(int k = 0; k < 4; k++)
            {
                int x = i + dx[k];
                int y = j + dy[k];

                if(x >= 0 && y >= 0 && x <= m - 1 && y <= n- 1)
                {
                    int newEffort = Math.max(
                        Math.abs(heights[x][y] - heights[i][j])
                        , effort
                    );

                    if(newEffort < dist[x][y])
                    {
                        dist[x][y] = newEffort;
                        pq.add(new Pair(x, y, newEffort));
                    }
                }
                
            }

        }

        return 0;
    }
}
