/* Problem - https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/

Distance from the Source (Bellman-Ford Algorithm)
Difficulty: MediumAccuracy: 48.11%Submissions: 109K+Points: 4
Given a weighted and directed graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S. If a vertices can't be reach from the S then mark the distance as 10^8. Note: If the Graph contains a negative cycle then return an array consisting of only -1.

Example 1:

Input:

E = [[0,1,9]]
S = 0
Output:
0 9
Explanation:
Shortest distance of all nodes from
source is printed.
Example 2:

Input:

E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
S = 2
Output:
1 6 0
Explanation:
For nodes 2 to 0, we can follow the path-
2-0. This has a distance of 1.
For nodes 2 to 1, we cam follow the path-
2-0-1, which has a distance of 1+5 = 6,
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function bellman_ford( ) which takes a number of vertices V and an E-sized list of lists of three integers where the three integers are u,v, and w; denoting there's an edge from u to v, which has a weight of w and source node S as input parameters and returns a list of integers where the ith integer denotes the distance of an ith node from the source node.

If some node isn't possible to visit, then its distance should be 100000000(1e8). Also, If the Graph contains a negative cycle then return an array consisting of a single -1.

 

Expected Time Complexity: O(V*E).
Expected Auxiliary Space: O(V).

 

Constraints:
1 ≤ V ≤ 500
1 ≤ E ≤ V*(V-1)
-1000 ≤ adj[i][j] ≤ 1000
0 ≤ S < V

*/

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int[] dist = new int[V];
        
        Arrays.fill(dist, (int)1e8);
        dist[S] = 0;
        
        for(int i = 0; i < V - 1; i++)
        {
            for(ArrayList<Integer> edge: edges)
            {
                int source = edge.get(0);
                int dest = edge.get(1);
                int weight = edge.get(2);
                
                if(dist[source] != 1e8 && dist[source] + weight < dist[dest])
                {
                    dist[dest] = dist[source] + weight;
                }
            }
        }
        
        for(ArrayList<Integer> edge: edges)
        {
            int source = edge.get(0);
            int dest = edge.get(1);
            int weight = edge.get(2);
            
            if(dist[source] != (int)1e8 && dist[source] + weight < dist[dest])
            {
                return new int[]{-1};
            }
        }
        
        return dist;
        
    }
}

/* Notes

First understand that you can reach any vertex in a graph from any other vertex by raversing at max V - 1 edges. So what this algorithm does that in first iteration it starts from weight of source edge.
Becuase that is the one which is not equal to "1e8". Now on the first iteration that edges with that source vertex will be processed updating the dist for the dest vertexes. Also, if there is a cycle
which end up with less weight then other alternative. It will be checked in some iteration and dist will be updated with lesser value.

Now on the second iteration edges related with those vertexes will be processed. So with V - 1 iteration at most all the vertexes would be processed. Now at last we process all the edges again. If stil
the distance is reducing . It means there is cycle with negative edge value.

*/