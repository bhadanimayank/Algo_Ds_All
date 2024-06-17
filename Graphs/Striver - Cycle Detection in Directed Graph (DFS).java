/* Problem - https://leetcode.com/problems/course-schedule-ii/description/

210. Course Schedule II
Solved
Medium
Topics
Companies
Hint
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.

*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        final List<Integer>[] adjacents = new List[numCourses];
        final int[] frequencies = new int[numCourses];

        int count = numCourses - 1;

        for(int[] prerequisite: prerequisites)
        {
            if(adjacents[prerequisite[0]] == null)
                adjacents[prerequisite[0]] = new ArrayList<>();

            adjacents[prerequisite[0]].add(prerequisite[1]);
            frequencies[prerequisite[1]]++;
        }

        final Queue<Integer> queue = new LinkedList<>();
        final int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
        {
            if(frequencies[i] == 0)
            {
                result[count--] = i;
                queue.offer(i);
            }
        }

        while(!queue.isEmpty())
        {
            final int i = queue.poll();

            for(int j = 0; adjacents[i] != null && j < adjacents[i].size(); j++)
            {
                final int p = adjacents[i].get(j);

                frequencies[p]--;

                if(frequencies[p] == 0) {
                    result[count--] = p;
                    queue.offer(p);
                }
            }
        }

        return count == -1 ? result: new int[0];
    }
}