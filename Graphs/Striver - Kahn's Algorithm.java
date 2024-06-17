/* Problem - https://www.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort
https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/

Topological sort
MediumAccuracy: 56.52%Submissions: 207K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains a list of all vertices j such that there is a directed edge from vertex i to vertex j, with  V  vertices and E  edges, your task is to find any valid topological sorting of the graph.

 

In a topological sort, for every directed edge u -> v,  u must come before v in the ordering.

 

Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.
Example 2:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0.
Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort()  which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns an array consisting of the vertices in Topological order. As there are multiple Topological orders possible, you may return any of them. If your returned topo sort is correct then the console output will be 1 else 0.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2

*/

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int[] indegree = new int[V];
        
        for(int i = 0; i < V; i++)
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
        
        int[] topo = new int[V];
        
        int index = 0;
        
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            
            topo[index++] = node;
            
            for(int neighbour: adj.get(node))
            {
                --indegree[neighbour];
                
                if(indegree[neighbour] == 0)
                {
                    queue.add(neighbour);
                }
            }
        }
        
        return topo;
    }
}

/* Notes
Go through Kahn's Algorithm provided in link above


*/