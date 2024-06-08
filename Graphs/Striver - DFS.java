/* Problem - https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
https://takeuforward.org/data-structure/depth-first-search-dfs/


DFS of Graph
EasyAccuracy: 63.07%Submissions: 246K+Points: 2
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


Example 1:

Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

Output: 0 2 4 3 1
Explanation: 
0 is connected to 2, 3, 1.
1 is connected to 0.
2 is connected to 0 and 4.
3 is connected to 0.
4 is connected to 2.
so starting from 0, it will go to 2 then 4,
and then 3 and 1.
Thus dfs will be 0 2 4 3 1.
Example 2:

Input: V = 4, adj = [[1,3], [2,0], [1], [0]]

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 0, 2. 
2 is connected to 1.
3 is connected to 0. 
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3. 

Your task:
You don't need to read input or print anything. Your task is to complete the function dfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a list containing the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 104

*/

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> dfs = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        
        stack.push(0);
        
        while( !stack.isEmpty() )
        {
            int pop = stack.pop();
            
            if(!visited[pop])
            {
                dfs.add(pop);
                visited[pop] = true;
                
                for( int i = adj.get(pop).size() - 1 ; i >= 0 ; i-- )
                {
                    int current = adj.get(pop).get(i);
                    stack.push(current);
                }
            }
        }
        
        return dfs;
    }

/* Notes

So BFS is printing nodes at next level from left to right before moving to next level of nodes

                                                           1
                                                           |
                                        ---------------------------------------
                                        |                  |                  |
                                        2                  3                  4
                                        |                  |                  |
                                  --------------     -------------      ------------
                                  |            |     |           |      |          |
                                  5            6     7           8      9          10


So BFS would be like  { 1 , 2 , 5 , 6 , 3 , 7 , 8 , 4 , 9 , 10 }

So what we are doing here, processing each nodes to get it's child node and putting child nodes into a stack , now we are popping each node printing the same processing it
and push it's child nodes at the.

*/