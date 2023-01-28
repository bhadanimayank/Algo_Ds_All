Problem - https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/

Count Ways To Reach The N-th Stairs

https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650

======================================================================================================================================
Solution -

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countDistinctWayToClimbStair(long nStairs) {
        int prevprev = 0;
        int prev = 1;
        int cur = 0;
        
        if(nStairs == 0)
        {
            return 1;
        }
        
        if(nStairs == 1)
        {
            return prev;
        }
        
        for(int i = 0; i < nStairs; i++)
        {
            cur = (prevprev + prev)%1000000007;
            prevprev = prev;
            prev = cur;
        }
        
        return cur;
	}
}
