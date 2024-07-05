/* Problem - https://leetcode.com/problems/network-delay-time/description/


Code


Testcase
Testcase
Test Result
743. Network Delay Time
Solved
Medium
Topics
Companies
Hint
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

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

    class Tuple {

        int node;
        int totalTime;

        public Tuple(int node, int totalTime)
        {
            this.node = node;
            this.totalTime = totalTime;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<Pair>());
        }

        for(int i = 0; i < times.length; i++)
        {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dist[k] = 0;

        int maxTime = Integer.MIN_VALUE;
        Queue<Tuple> queue = new LinkedList<Tuple>();

        queue.add(new Tuple(k, 0));

        while(!queue.isEmpty())
        {
            Tuple tuple = queue.poll();

            for(Pair neighbour: adj.get(tuple.node))
            {
                if(dist[neighbour.node] > tuple.totalTime + neighbour.time)
                {
                    dist[neighbour.node] = tuple.totalTime + neighbour.time;
                    queue.add(new Tuple(neighbour.node, dist[neighbour.node]));
                }
            }

        }

        for(int i = 0 ; i <= n; i++)
        {
            if(dist[i] == Integer.MAX_VALUE)
            {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}