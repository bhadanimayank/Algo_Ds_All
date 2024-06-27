/* Problem - https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

Directed Graph Cycle
Difficulty: MediumAccuracy: 27.88%Submissions: 372K+Points: 4
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You dont need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list adj as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.
In the adjacency list adj, element adj[i][j] represents an edge from i to j.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105

*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        
        int[] indegree = new int[V];
        
        for(int i = 0; i < adj.size(); i++)
        {
            for(int neighbour: adj.get(i))
            {
                ++indegree[neighbour];
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < V; i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }
        
        int count = 0;
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            
            ++count;
            
            for(int neighbour: adj.get(current))
            {
                --indegree[neighbour];
                
                if(indegree[neighbour] == 0)
                {
                    queue.add(neighbour);
                }
            }
            
        }
        
        return count < V ? true: false;
    }
}

/* Notes

Consider below graph with a cycle 1 -> 2 -> 3 -> 1

0 ----------> 1  --------> 2 ----------> 3
              ^                         |
              |                         |
              ---------------------------

now suppose 0 is being polled out of queue, it's neighbour will be 1 with degree 2
now for vertex 1 degree will be reduced to 1. But nothing will be put on queue as 1 still have indgree 1.
So queue will be exausted or Empty. Ofcourse count will be incremented to 1 as vertex 1 was processed.

Therefore count will be less than count of vertex for a cyclic graph/
*/