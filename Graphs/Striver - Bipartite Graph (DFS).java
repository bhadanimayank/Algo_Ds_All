/* Problem -    https://leetcode.com/problems/is-graph-bipartite/description/

https://takeuforward.org/graph/bipartite-graph-dfs-implementation/

785. Is Graph Bipartite?
Solved
Medium
Topics
Companies
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 

Constraints:

graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.

*/

class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        int c = 0;
        boolean ans = true;

        for(int i = 0; i < n; i++)
        {
            if(color[i] == -1)
            {
                ans = ans && dfs(graph, color, i, c);
            }
        }

        return ans;
    }

    public boolean dfs(int[][] graph, int[] color, int node, int c)
    {
        color[node] = c;
        int m = graph[node].length;
        boolean ret = true;

        for(int i = 0; i < m; i++)
        {
            int neighbour = graph[node][i];

            if(color[neighbour] == color[node])
                return false;
            else if(color[neighbour] == -1)
                ret = ret && dfs(graph, color, neighbour, 1 - c);
        }
        return ret;
    }
    
}

/* Notes

We initialize the colors to the length of number of nodes. Now we initilize the algorithm with marking the color at index 0 as 0.
Now we start doing dfs and mark the neighbour nodes as (1 - c) = 1 (see **). We only mark the neighbour if it's already not visisted, checking by value -1.

Also if the neighbour and node color is same, return false.

To highlight, a bipartite grapg is the one, if all the neighbouring nodes in grapg can be marked in altermnative color.


**
if c = 0 (1 - c) = 1
if c = 1 (1 - c) = 0

*/