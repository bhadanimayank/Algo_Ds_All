/* Problem - https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

https://takeuforward.org/graph/striver-graph-series-top-graph-interview-questions

BFS of graph
EasyAccuracy: 44.09%Submissions: 363K+Points: 2
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.


Example 1:

Input:
V = 5, E = 4
adj = {{1,2,3},{},{4},{},{}}


Output: 
0 1 2 3 4
Explanation: 
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3. After this 2 to 4, thus bfs will be
0 1 2 3 4.
Example 2:

Input:
V = 3, E = 2
adj = {{1,2},{},{}}

Output: 
0 1 2
Explanation:
0 is connected to 1 , 2.
so starting from 0, it will go to 1 then 2,
thus bfs will be 0 1 2. 

Your task:
You dont need to read input or print anything. Your task is to complete the function bfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns  a list containing the BFS traversal of the graph starting from the 0th vertex from left to right.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 104

*/

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> bfs = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        int size = V;
        
        boolean[] visited = new boolean[size];
        
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty())
        {
            int pop = queue.poll();
            bfs.add(pop);
            
            for( int i = 0; i < adj.get(pop).size(); i++ )
            {
                int current = adj.get(pop).get(i);
                
                if(visited[current] != true)
                {
                    queue.add(current);
                    visited[current] = true;
                }
            }
            
        }
        
        return bfs;
    }
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


So BFS would be like  { 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 }

So what we are doing here, processing each nodes to get it's child node and putting child nodes into a queue , now we are polling each node printing the same processing it
and push it's child nodes at the end of queue.

So at the start of the queue we will have nodes in each level in sequence from left to right, then their children will be next sequentially from left to right

So 1 we will insert in queue {1}
now we will print 1 and then insert  child nodes { 2, 3, 4 } in queue and print 1 { 1, 2 , 3, 4 }

now we will print 2 and insert it's child nodes { 2, 3, 4, 5, 6 }

now we will print 3 and insert it's child nodes { 3, 4, 5, 6, 7, 8} and so on 

=================================================================================================================================================================================

Applications of BFS of A graph  :

In peer-to-peer network like bit-torrent, BFS is used to find all neighbor nodes
Search engine crawlers are used BFS to build index. Starting from source page, it finds all links in it to get new pages
Using GPS navigation system BFS is used to find neighboring places.
In networking, when we want to broadcast some packets, we use the BFS algorithm.
Path finding algorithm is based on BFS .
BFS is used in Ford-Fulkerson algorithm to find maximum flow in a network.
Applications of BFS in AI:
Breadth-first search can be used to solve many problems in graph theory, for example: Copying garbage collection, Cheney's algorithm. Finding the shortest path between two nodes u and v, with path length measured by number of edges .

Complexity Analysis:

The time complexity of BFS algorithm is O(V+E), since in the worst case, BFS algorithm explores every node and edge. In a graph, the number of vertices is O(V), whereas the number of edges is O(E).
The space complexity of BFS can be expressed as O(V), where V is the number of vertices.

*/

