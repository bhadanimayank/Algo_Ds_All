/* Problem - https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

https://takeuforward.org/data-structure/g-40-number-of-ways-to-arrive-at-destination/

1976. Number of Ways to Arrive at Destination
Attempted
Medium
Topics
Companies
Hint
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 

Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:

1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.

*/

class Solution {

    class Pair {
        int node;
        int time;

        public Pair(int node, int time)
        {
            this.node = node;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++)
        {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.time - y.time);

        int[] dist = new int[n];
        int[] ways = new int[n];

        for(int i = 0; i < n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        int mod = (int)(1e9 + 7);

        while(pq.size() != 0)
        {
            Pair current = pq.poll();
            int node = current.node;
            int time = current.time;

            for(Pair neighbour: adj.get(node))
            {
                int neighbourNode = neighbour.node;
                int neighbourTime = neighbour.time;

                if(time + neighbourTime < dist[neighbourNode])
                {
                    dist[neighbourNode] = (int)(time + neighbourTime);
                    pq.add(new Pair(neighbourNode, (int)(time + neighbourTime)));
                    ways[neighbourNode] = ways[node];
                } 
                else if(time + neighbourTime == dist[neighbourNode])
                {
                    ways[neighbourNode] = (ways[neighbourNode] + ways[node]) % mod;
                }
            }

        }

        return ways[n - 1] % mod;
        
    }
}

/* Notes

Combination of BFS and simple Dynamic Programming.

*/