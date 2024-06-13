/* Problem - https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/
https://leetcode.com/problems/surrounded-regions/description/

130. Surrounded Regions
Solved
Medium
Topics
Companies
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.

 

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

*/

class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 || j == 0 || i == (m - 1) || j == (n - 1))
                {
                    dfs(board, i, j);
                }
            }
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 'B')
                {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j)
    {
        int m = board.length;
        int n = board[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O')
            return;

        board[i][j] = 'B';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}

/* Notes

Use DFS to mark all the boarder and ralted O to B, now mark all the remaining O to X, Update B to O

*/