/* Problem - https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph-having-unit-distance

https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/

You are given an Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.

Example1:

Input:
n = 9, m= 10
edges=[[0,1],[0,3],[3,4],[4,5],[5,6],[1,2],[2,6],[6,7],[7,8],[6,8]] 
src=0
Output:
0 1 2 1 2 3 3 4 4
Explanation:
Example2:

Input:
n = 4, m= 4
edges=[[0,0],[1,1],[1,3],[3,0]] 
src=3
Output:
1 1 -1 0
Explanation:
Your Task:
You don't need to print or input anything. Complete the function shortest path() which takes a 2d vector or array of edges representing the edges of an undirected graph with unit weight, an integer n as the number of nodes, an integer m as a number of edges and an integer src as the input parameters and returns an integer array or vector, denoting the vector of distance from src to all nodes.

Constraint:
1<=n,m<=10000
0<=edges[i][j]<=n-1

Expected Time Complexity: O(N + E), where N is the number of nodes and E is the edges
Expected Space Complexity: O(N)

*/

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        int[] dist = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            dist[i] = (int)1e9;
        }
        
        dist[src] = 0;
        
        queue.add(src);
        
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            
            for(int neighbour: adj.get(node))
            {
                if( dist[node] + 1 < dist[neighbour] )
                {
                    dist[neighbour] = dist[node] + 1;
                
                    queue.add(neighbour);
                }
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            if(dist[i] == (int)1e9)
            {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}

/* Notes

Primarily evolution of topo sort algorithm. The primary change is we are declaring an array distance and initize them with max distance.
now we are initializing queue with src node. now we are going through their neighbours. Comparing the existing distance with the distance with node(which have dist with src).
Update them if the distance is less. Now add this neighbour node to the queue. So next time their immediate neighbours will have chance to compare and update.

*/