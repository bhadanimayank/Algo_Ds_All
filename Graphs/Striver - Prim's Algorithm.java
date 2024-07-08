/* Problem - https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/

Minimum Spanning Tree
Difficulty: MediumAccuracy: 47.82%Submissions: 122K+Points: 4
Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. The graph is represented by an adjacency list, where each element adj[i] is a vector containing pairs of integers. Each pair represents an edge, with the first integer denoting the endpoint of the edge and the second integer denoting the weight of the edge.

Example 1:

Input:
3 3
0 1 5
1 2 3
0 2 1

Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Example 2:

Input:
2 1
0 1 5

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.
 

Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function spanningTree() which takes a number of vertices V and an adjacency list adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains vectors of size 2, where the first integer in that vector denotes the end of the edge and the second integer denotes the edge weight.

Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V2).
 

Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges.

*/

class Pair {
    int node;
    int distance;
    
    public Pair(int node, int distance)
    {
        this.node = node;
        this.distance = distance;
    }
}
    

class Solution {
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        
        int sum = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        
        pq.add(new Pair(0, 0));
        
        while(!pq.isEmpty())
        {
            Pair current = pq.poll();
            
            if(visited[current.node])
             continue;
             
            visited[current.node] = true;
            sum = sum + current.distance;
             
            for(int[] neighbour: adj.get(current.node))
            {
                if(!visited[neighbour[0]])
                {
                    pq.add(new Pair(neighbour[0], neighbour[1]));
                }
            }
        }
        
        return sum;
    }
}

/* Notes

Simple BFS Algorithm with visisted array to prent visisting a visited array again. PriorityQueue to pick the nodes with shortest distance first

*/