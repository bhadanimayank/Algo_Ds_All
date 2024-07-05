/* Problem - https://takeuforward.org/graph/striver-graph-series-top-graph-interview-questions

https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

787. Cheapest Flights Within K Stops
Solved
Medium
Topics
Companies
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst


*/

class Solution {

    class Pair
    {
        int node;
        int cost;
        
        public Pair(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }
    }

    class Tuple {
        int node;
        int cost;
        int steps;

        public Tuple(int node, int cost, int steps)
        {
            this.node = node;
            this.cost = cost;
            this.steps = steps;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < flights.length; i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n]; 

        for(int i = 0; i < n; i++)
        {
            dist[i] = Integer.MAX_VALUE; 
        }

        dist[src] = 0; 

        Queue<Tuple> queue = new LinkedList<Tuple>();

        queue.add(new Tuple(src, 0, 0));

        while(!queue.isEmpty())
        {
            Tuple current = queue.poll();

            if(current.steps > k)
                continue;

            for(Pair neighbour: adj.get(current.node))
            {
                if(neighbour.cost + current.cost < dist[neighbour.node] && current.steps <= k)
                {
                    dist[neighbour.node] = neighbour.cost + current.cost;
                    queue.add(new Tuple(neighbour.node, neighbour.cost + current.cost, 1 + current.steps));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE)
            return -1; 
        
        return dist[dst];
    }
}

