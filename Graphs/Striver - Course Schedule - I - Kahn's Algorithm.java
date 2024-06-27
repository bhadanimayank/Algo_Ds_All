/* Problem - https://leetcode.com/problems/course-schedule/description/

https://leetcode.com/problems/course-schedule/description/

207. Course Schedule
Solved
Medium
Topics
Companies
Hint
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

*/

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] dependencyArray = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++)
        {
            ++dependencyArray[prerequisites[i][0]];
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++)
        {
            if(dependencyArray[i] == 0)
            {
                queue.add(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty())
        {
            int current = queue.poll();

            ++count;

            for(int i = 0; i < prerequisites.length; i++)
            {
                if(prerequisites[i][1] == current)
                {
                    --dependencyArray[prerequisites[i][0]];
                    
                    if(dependencyArray[prerequisites[i][0]] == 0)
                    {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return count < numCourses ? false : true;
    }
}

/* Notes

Solved using Kahn's algorithm. If you closely observe it's a directed graph cycle detection problem. The only way courses cannot be finished if course a is dependent on b and course b is dependent on a.
Look into basic problem - bhadanimayank/Algo_Ds_All/Graphs/Striver - Cycle Detection in Directed Graph (BFS) - Kahn's Algorithm.java


*/