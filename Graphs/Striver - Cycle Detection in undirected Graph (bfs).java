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


 

Constraints:
1 ≤ V, E ≤ 105

*/

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++)
        {
            if(!visited[i] && /* dfs(adj, visited, i, -1) */  bfs(adj, visited, i))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int dependency)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        int[] parent = new int[adj.size()];
        Arrays.fill(parent, -1);
        
        queue.offer(dependency);
            
        visited[dependency] = true;
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            
            for(int i = 0; i < adj.get(current).size(); i++)
            {
                int child = adj.get(current).get(i);
                
                if(!visited[child])
                {
                    queue.offer(child);
                    visited[child] = true;
                    parent[child] = current;
                }
                else if(parent[current] != child)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}

/* Notes
Simple bfs algorithm implemented via queue. To detect a cycle here we initaited parent array and fill the array every time processing polled element and indicate parents.
To detect a cycle, we check if we are visiting a visited element again. Only exception is if the chiild is parent of parent too. As this is an undirceted graph.

So in adj graph representation for a edge 1 - 2, it will be represented as 

1 -> 2
2 -> 1

but it's not reprenting a cycle

*/