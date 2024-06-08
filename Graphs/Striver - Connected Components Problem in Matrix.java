/* Problem - https://www.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-provinces

Number of Provinces
MediumAccuracy: 54.29%Submissions: 94K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Example 1:

Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]

Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.
Example 2:
Input:
[
 [1, 1],
 [1, 1]
]

Output :
1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function numProvinces() which takes an integer V and an adjacency matrix adj(as a 2d vector) as input and returns the number of provinces. adj[i][j] = 1, if nodes i and j are connected and adj[i][j] = 0, if not connected.


Expected Time Complexity: O(V2)
Expected Auxiliary Space: O(V)

*/

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V)
    {
        // code here
        boolean[] visited = new boolean[V];
        
        int ans = 0;
        
        for( int i = 0; i < V; i++ )
        {
            if(!visited[i])
            {
                ++ans;
                dfs(adj, visited, i);
                
            }
        }
        
        return ans;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i)
    {
        if(!visited[i])
        {
            visited[i] = true;
            
            for(int j = 0; j < adj.get(i).size(); j++)
            {
                int current = adj.get(i).get(j);
                
                if(current == 1 && !visited[j])
                {
                    dfs(adj, visited, j);
                }
            }
        }
    }
};

// Notes - See notes for bhadanimayank/Algo_Ds_All/Graphs/Striver - Number of provinces (leetcode).java