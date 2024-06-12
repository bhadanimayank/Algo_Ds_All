/* Problem - https://leetcode.com/problems/01-matrix/description/
https://takeuforward.org/graph/distance-of-nearest-cell-having-1/

542. 01 Matrix
Solved
Medium
Topics
Companies
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int[] DIR = {0, 1, 0, -1, 0};

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                    queue.offer(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }

        while(!queue.isEmpty())
        {
            int[] current = queue.poll();

            int i = current[0], j = current[1];

            for(int k = 0; k < 4; k++)
            {
                int x = i + DIR[k];
                int y = j + DIR[k + 1];

                if(x >= 0 && y >= 0 && x < m && y < n && mat[x][y] == -1)
                {
                    mat[x][y] = 1 + mat[i][j];
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return mat;
        
    }
}

/* Notes

Basically a BFS Algorithm, We are populating the queue with 0 positions, and thne polling that position, finding the neighbours and updating distance from pollled position. 
Also at start we mark -1 all the 1 position to identify and sperate them from the distance we are supposed to update later.

*/