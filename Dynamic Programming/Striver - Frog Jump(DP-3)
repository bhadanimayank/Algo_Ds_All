Problem - https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/

https://www.codingninjas.com/codestudio/problems/frog-jump_3621012

=====================================================================================================================================================

Solution :

import java.util.* ;
import java.io.*; 
import java.lang.*;

public class Solution { 
    public static int frogJump(int n, int heights[]) {
        int[] cost = new int[n];
        cost[0] = 0;
        cost[1] = Math.abs(heights[1] - heights[0]);
        
        for(int i = 2; i < n; i++)
        {
            cost[i] = Math.min( 
                          cost[i - 1] + Math.abs(heights[i] - heights[i - 1]),
                          cost[i - 2] + Math.abs(heights[i] - heights[i - 2])
                      );
        }
        
        
        return cost[n - 1];
    }
    
    /*
    public static int frogJump(int n, int heights[]) {
        int prevprev = 0;
        int prev = Math.abs(heights[1] - heights[0]);
        int cost = 0;
        
        for(int i = 2; i < n; i++)
        {
            
            cost = Math.min( 
                          prev + Math.abs(heights[i] - heights[i - 1]),
                          prevprev + Math.abs(heights[i] - heights[i - 2])
                      );
            
            prevprev = prev;
            prev = cost;
            
        }
        
        return cost;
    }
    */

}
