Problem
746. Min Cost Climbing Stairs 

Category - Easy

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999


Solution
----------------------------------------------------------------------------------------------------------

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int first = cost[0], second = cost[1], temp;
        
        for(int i = 2 ; i < cost.length ; i++)
        {
            temp = second;
            second = Math.min(first, second) + cost[i];
            first = temp;
        }
        
        return Math.min(first, second);
        
    }
}

Notes
-----------------------------------------------------------------------------------------------------------
1) Suppose you are on a step x and have to pay the cost. But at this step, either you have come from step (x-1) or (x-2) as you could have taken 1 or 2 step to reach at step x.

2)  If you have to minimize the total cost, you could have come from a step which is minimun of either step (x-1) or (x-2).

3) Above step gets repeat for each step. So when you are on step (x+1), you could have come from either step x or (x-1) whichever is minimum.


Submission Report
------------------------------------------------------------------------------------------------------------
Runtime: 0 ms, faster than 100.00% of Java online submissions for Min Cost Climbing Stairs.
Memory Usage: 38.9 MB, less than 54.97% of Java online submissions for Min Cost Climbing Stairs.
Next challenges:
