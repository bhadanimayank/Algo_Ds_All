/* Problem - https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

https://takeuforward.org/data-structure/dijkstras-algorithm-using-set-g-33/

Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers denoting shortest distance between each node and Source vertex S.
 

Note: The Graph doesn't contain any negative weight cycle.

 

Example 1:

Input:
V = 2
adj [] = {{{1, 9}}, {{0, 9}}}
S = 0
Output:
0 9
Explanation:

The source vertex is 0. Hence, the shortest 
distance of node 0 is 0 and the shortest 
distance from node 1 is 9.
 

Example 2:

Input:
V = 3, E = 3
adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
S = 2
Output:
4 3 0
Explanation:

For nodes 2 to 0, we can follow the path-
2-1-0. This has a distance of 1+3 = 4,
whereas the path 2-0 has a distance of 6. So,
the Shortest path from 2 to 0 is 4.
The shortest distance from 0 to 1 is 1 .
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function dijkstra()  which takes the number of vertices V and an adjacency list adj as input parameters and Source vertex S returns a list of integers, where ith integer denotes the shortest distance of the ith node from the Source node. Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j and the second integer w denotes that the weight between edge i and j is w.

 

Expected Time Complexity: O(V2).
Expected Auxiliary Space: O(V2).

 

Constraints:
1 ≤ V ≤ 1000
0 ≤ adj[i][j] ≤ 1000
1 ≤ adj.size() ≤ [ (V*(V - 1)) / 2 ]
0 ≤ S < V


*/

//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] visited = new int[V];
        int[] dist = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Pair(S, 0));
        
        while(!pq.isEmpty())
        {
            Pair current = pq.poll();
            
            int node = current.node;
            int weight = current.weight;
            
            ArrayList<ArrayList<Integer>> neighbours = adj.get(node);
            
            for(ArrayList<Integer> neighbour: neighbours)
            {
                if(visited[neighbour.get(0)] == 0)
                {
                    if(dist[node] + neighbour.get(1) < dist[neighbour.get(0)])
                    {
                        dist[neighbour.get(0)] = dist[node] + neighbour.get(1);
                        pq.offer(new Pair(neighbour.get(0), dist[neighbour.get(0)]));
                    }
                }
            }
            
            visited[node] = 1;
        }
        
        return dist;
        
    }
    
    static class Pair
    {
        int node;
        int weight;
        
        public Pair(int node, int weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }
}


/* Notes
    Simpe graph traversal algorithm with modifications with weight. 
    To understand the input structure better, observe the input. Would understand it better.

    adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}

    var neighbours = adj.get(0) -> {{1, 1}, {2, 6}}, {{2, 3}}

    var neighbour = neighbours.get(0) -> {1, 1}

    var node = neighbour.get(0)
    var weight = neighbour.get(1)

*/