/* Problem - https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph

https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/

Detect cycle in an undirected graph
MediumAccuracy: 30.13%Submissions: 396K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

Example 1:

Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.
Example 2:

Input: 
V = 4, E = 2
adj = {{}, {2}, {1, 3}, {2}}
Output: 0
Explanation: 

No cycle in the graph.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.

NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.

 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)

*/

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++)
        {
            if(!visited[i] && dfs(adj, visited, i, -1))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int dependency, int parent)
    {
        if(visited[dependency])
            return true;
        
        visited[dependency] = true;
        
        for(int nbr : adj.get(dependency))
        {
            if(nbr != parent && dfs(adj, visited, nbr, dependency))
                return true;
        }
        
        return false;
    }
}

/* Notes

We are here itertaively folowing each entry in graph and by updating and checking visisted array tryng to detect if a cycle exist in the graph or not.

Imporatant condition (nbr != parent) in line 72 is present to check if the undirected relation between two nodes won't be wrongly flagged as cycle

Because in the undirectional graph representation between 1 and 2

1 will have entry of 2
and 2 will have entry of 1

So have to take care of this point while searching cycles
*/