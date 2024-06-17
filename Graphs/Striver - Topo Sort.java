/* Problem - https://www.geeksforgeeks.org/problems/topological-sort/1

https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/

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
        int[] visited = new int[V];
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == 0)
            {
                dfs(adj, visited, stack, i);
            }
        }
        
        int[] ans = new int[V];
        
        int i = 0;
        
        while(!stack.isEmpty())
        {
            ans[i++] = stack.pop();
        }
        
        return ans;
        
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack, int node)
    {
        visited[node] = 1;
        
        for(int neighbour: adj.get(node))
        {
            if(visited[neighbour] == 0)
            {
                dfs(adj, visited, stack, neighbour);
            }
        }
        
        stack.push(node);
    }
}


/*Notes

Simply dfs but stack.push will happen after visiting neighbours to normalize the order because in topological sort  if graph 0 -> 1 -> 2 [0, 1, 2].

*/