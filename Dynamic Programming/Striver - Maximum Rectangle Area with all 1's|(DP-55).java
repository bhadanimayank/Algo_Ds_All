/* Problem - https://leetcode.com/problems/maximal-rectangle/description/

https://takeuforward.org/data-structure/maximum-rectangle-area-with-all-1s-dp-on-rectangles-dp-55/

85. Maximal Rectangle
Solved
Hard
Topics
Companies
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.

*/

class Solution {
    public int maximalRectangle(char[][] matrix) {

        int maxArea = 0;

        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 )
            return maxArea;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols + 1];

        Arrays.fill(heights, 0);

        for(char[] row: matrix)
        {
            for(int i = 0; i < row.length; i++)
            {
                heights[i] =  row[i] == '1' ? heights[i] + 1 : 0;
            }

            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < heights.length; i++)
            {
                while( !stack.isEmpty() && heights[i] < heights[stack.peek()] )
                {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;

                    maxArea = Math.max(maxArea, h * w);
                }

                stack.push(i);
            }
        }

        return maxArea;
    }
}


// NOtes - See the solution for Area of Histogram Problem, it is just the extended version of it