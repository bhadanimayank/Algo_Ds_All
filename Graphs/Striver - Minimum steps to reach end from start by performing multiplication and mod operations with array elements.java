/* Problem - https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-multiplications-to-reach-end

https://takeuforward.org/graph/g-39-minimum-multiplications-to-reach-end/

Minimum Multiplications to reach End
Difficulty: MediumAccuracy: 48.94%Submissions: 99K+Points: 4
Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6 
Step 2: 6*5 = 30 % 100000 = 30
Example 2:

Input:
arr[] = {3, 4, 65}
start = 7, end = 66175
Output:
4
Explanation:
Step 1: 7*3 = 21 % 100000 = 21 
Step 2: 21*3 = 63 % 100000 = 63 
Step 3: 63*65 = 4095 % 100000 = 4095 
Step 4: 4095*65 = 266175 % 100000 = 66175
Your Task:
You don't need to print or input anything. Complete the function minimumMultiplications() which takes an integer array arr, an integer start and an integer end as the input parameters and returns an integer, denoting the minumum steps to reach in which end can be achieved starting from start.

Expected Time Complexity: O(105)
Expected Space Complexity: O(105)

Constraints:

1 <= n <= 104
1 <= arr[i] <= 104
1 <= start, end < 105


*/

class Solution {
    
    class Pair 
    {
        int number, steps; 
    
        Pair(int number, int steps) {
            this.number = number;
            this.steps = steps; 
        }
    }
    
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        
        if(start == end)
            return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        
        int[] dist = new int[100000];
        
        for(int i = 0 ; i < 100000; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[start] = 0; 
        int mod = 100000;
        
        while(!queue.isEmpty())
        {
            Pair pair = queue.poll();
            
            for(int i = 0; i < arr.length; i++)
            {
                int num = (pair.number * arr[i]) % 100000;
                
                if(pair.steps + 1 < dist[num])
                {
                    dist[num] = pair.steps + 1;
                    
                    if(num == end)
                    {
                        return dist[num];
                    }
                    
                    queue.add(new Pair(num, dist[num]));
                }
            }
        }
        
        return -1;
    }
}

/* Notes

Simple BFS

*/