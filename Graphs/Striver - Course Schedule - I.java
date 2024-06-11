/* Problem - https://leetcode.com/problems/course-schedule/description/

https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/

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
        
        if( numCourses <= 0 )
            return false;

        if( numCourses > 0 && prerequisites.length == 0 )
            return true;

        var graph = new HashMap<Integer, ArrayList<Integer>>();
        
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited, true);

        for(int[] prerequisite: prerequisites)
        {
            var elem = prerequisite[0];
            var dep = prerequisite[1];

            if(!graph.containsKey(elem))
                graph.put(elem, new ArrayList<Integer>());

            if(!graph.containsKey(dep))
                graph.put(dep, new ArrayList<Integer>());

            graph.get(elem).add(dep);
            visited[elem] = false;
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry: graph.entrySet())
        {
            var node = entry.getKey();
            Set<Integer> set = new HashSet<Integer>();

            if(!dfs(graph, visited, set, node))
                return false;
        }

        for(var elem: visited)
        {
            if(!elem)
                return false;
        }

        return true;
    }

    public boolean dfs(HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited, Set<Integer> set, int dependency)
    {
        if(visited[dependency])
        {
            return true;
        }

        
        if(set.contains(dependency))
        {
            return false;
        }

        set.add(dependency);

        if(graph.get(dependency) == null)
        {
            return true;
        }

        ArrayList<Integer> nextdependencies = graph.get(dependency);

        for(int nextdependency: nextdependencies)
        {
            if(!dfs(graph, visited, set, nextdependency))
            {
                return false;
            }
        }

        return visited[dependency] = true;
    }
}

/* Notes

First we created dependency graph. So for input {0, 1} {0, 2} {1, 2}

graph :
        0 -> 1, 2
        1 -> 2

Now we process above one by one. Also we create visisted graph and initialize all to true.
While initializing the graph, For element which have dependency we need to mark them as false, this will leave elem as true which have no dependency.

Now we will process each element in graph, also we will build a set to check if there is cycle in dependency. If we have the last dependency as true, it will go
back in recursive function and mark all the chain dependency as visited = true.

Als of cource, while processing a dependency we check visited graph, if true we need not to process further.

*/