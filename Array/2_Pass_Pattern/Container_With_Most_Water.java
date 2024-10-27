// https://leetcode.com/problems/container-with-most-water/description/

//

/*
11. Container With Most Water
Solved
Medium
Topics
Companies
Hint
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/

// Java

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        
        int maxArea = 0; 

        while(left < right)
        {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if(height[left] < height[right])
            {
                ++left;
            }
            else
            {
                --right;
            }
        }
        
        return maxArea;
        
    }
}

// C#

public class Solution {
    public int MaxArea(int[] height) {
         
        int left = 0;
        int right = height.Length - 1;
        
        int maxArea = 0; 

        while(left < right)
        {
            maxArea = Math.Max(maxArea, (right - left) * Math.Min(height[left], height[right]));

            if(height[left] < height[right])
            {
                ++left;
            }
            else
            {
                --right;
            }
        }
        
        return maxArea;

    }
}



/* Notes

So we have two pointers left and right, we move the pointer which is lower of the two to find the next bigger wall.
With each move, we calculate the area of water holding and compare it to last calculation to find the max.

*/