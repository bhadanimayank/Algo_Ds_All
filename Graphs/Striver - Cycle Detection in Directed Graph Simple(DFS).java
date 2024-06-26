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
        // code here
        boolean[] visited = new boolean[V];
        Set<Integer> currentRec = new HashSet<>();;
        
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                if(dfs(i, adj, visited, currentRec))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Set<Integer> currentRec)
    {
        visited[node] = true;
        currentRec.add(node);
        
        for(int neighbour: adj.get(node))
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour, adj, visited, currentRec))
                {
                    return true;
                }
            }
            else if(currentRec.contains(neighbour))
            {
                return true;
            }
        }
        
        currentRec.remove(node);
        return false;
    }
}

/* Notes

We are using DFS here to itirate through the graph. Assumption here is that graph might be disconnected, Therefore we are looping through all the
nodes in the main function. If the node is already visisted, we are tracking it through the visisted array. So we don't have to visit it again

***
Now why we need the currentRec hashset? While we are recursively iterating through the graph, we need to check if the nodes are already visited
in that particular recursion indicating a loop.

Now second query could be why we need to remove the node from currentRec. So consider below graph

1   ->  2  ->  3
|              |
|------------->|

So above is not a loop becuase directions are on the same side. So if we will not remove the nodes while backtracking. It's goona detect a cycle
in above graph because 3 will show up in hashset while going from 1 -> 3 because we have already visited 3 through 1 -> 2 -> 3

By removing the node from currentRec, when we are iterating through 1 -> 2 -> 3. At 3 it will be removed from currentRec.So it will not be detected 
while iterating through 1 -> 3

Now consider below graph

1   ->  2  ->  3
|              |
|<-------------|

Now here is the loop present. So while iterating through 1 -> 2 -> 3 -> 1, the hashset will detect a loop.at the first go.


*/