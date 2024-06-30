/* Problem - https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph

https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/

Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

Example1:

Input:
N = 4, M = 2
edge = [[0,1,2],[0,2,1]]
Output:
0 2 1 -1
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->2 with edge weight 1.
There is no way we can reach 3, so it's -1 for 3.
Example2:

Input:
N = 6, M = 7
edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
Output:
0 2 3 6 1 5
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
Shortest path from 0 to 4 is 0->4 with edge weight 1.
Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
Your Task:

You don't need to print or input anything. Complete the function shortest path() which takes an integer N as number of vertices, an integer M as number of edges and a 2D Integer array(or vector) edges as the input parameters and returns an integer array(or vector), denoting the list of distance from src to all nodes.

Expected Time Complexity: O(N+M), where N is the number of nodes and M is edges
Expected Space Complexity: O(N)

Constraint:
1 <= N <= 100
1 <= M <= min((N*(N-1))/2,4000)
0 <= edgei,0,edgei,1 < n
0 <= edgei,2 <=105

*/

class Solution {
    
    class Pair{
        
        public int vertex, weight;
        public Pair(int a, int b)
        {
            vertex = a;
            weight = b;
        }
    }
    
    private void topoSort(int node, ArrayList < ArrayList < Pair >> adj, int[] vis, Stack <Integer> stack)
    {
        vis[node] = 1;
        
        for(int i = 0; i < adj.get(node).size(); i++)
        {
            int v = adj.get(node).get(i).vertex;
            
            if(vis[v] == 0)
            {
                topoSort(v, adj, vis, stack);
            }
        }
        stack.add(node);
    }
    

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
		{
		    adj.add(new ArrayList<Pair>());
		}
		
		for(int i = 0; i < M; i++)
		{
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		
		int[] vis = new int[N];
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++)
		{
		    if(vis[i] == 0)
		        topoSort(i, adj, vis, stack);
		}
		
		int dist[] = new int[N];
		
		for (int i = 0; i < N; i++) {
            dist[i] = (int)(1e9);
		}
            
        dist[0] = 0;
        
        while(!stack.isEmpty())
        {
            int node = stack.pop();
            
            for(int i = 0; i < adj.get(node).size(); i++)
            {
                int v = adj.get(node).get(i).vertex;
                int wt = adj.get(node).get(i).weight;
                
                if(dist[node] + wt < dist[v])
                {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        
        for (int i = 0; i < N; i++) 
        {
            if (dist[i] == 1e9)
                dist[i] = -1;
        }
        
        return dist;
    }
		
}

/* Notes
Topo Short Modified version

*/

