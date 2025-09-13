/* Problem - https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/

1547. Minimum Cost to Cut a Stick
Solved
Hard
Topics
Companies
Hint
Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:


Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.

You should perform the cuts in order, you can change the order of the cuts as you wish.

The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.

 

Example 1:


Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:

The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).
Example 2:

Input: n = 9, cuts = [5,6,1,4,2]
Output: 22
Explanation: If you try the given cuts ordering the cost will be 25.
There are much ordering with total cost <= 25, for example, the order [4, 6, 5, 2, 1] has total cost = 22 which is the minimum possible.
 

Constraints:

2 <= n <= 106
1 <= cuts.length <= min(n - 1, 100)
1 <= cuts[i] <= n - 1
All the integers in cuts array are distinct.

*/

class Solution {
    public int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);

        int m = cuts.length;
        int[][] dp = new int[m + 2][m + 2];

        for(int[] row: dp)
            Arrays.fill(row, 0);

        int z = m + 2;

        int[] ncuts = new int[z];
        ncuts[0] = 0;
        ncuts[z - 1] = n;

        for( int i = 0; i < m; i++ )
        {
            ncuts[i + 1] = cuts[i];             
        }

        return solve(1 ,m ,ncuts, dp);
    }

    public int solve(int i, int j, int[] ncuts, int[][] dp)
    {
        if(i > j)
            return 0;

        int mini = Integer.MAX_VALUE;

        if( dp[i][j] != 0 )
            return dp[i][j];

        for( int k = i; k <= j; k++ )
        {
            int cost = ( ncuts[j + 1] - ncuts[i - 1] )
                     + solve(i ,k - 1, ncuts, dp) + solve(k + 1, j, ncuts, dp);

            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }

}

/* Notes

First let's understand what is partition dp problem and how to solve it.  The normal dp problem usually are calculated by evaluating all the possibilities of solving the problem. Here the order of solving these optional possibilities
also matter.

For Ex: in above problem the final cost will depend on where should we start to cut the stick and in which order we execute the further cutting assignments.

So we evaluate each cutting position inside for loop and then recursively evaluating other cutting possibilities inside that cut.

As an extra note, we appended 0 and end of the rod position to indicate the already existing cuts. Also ordered the cut order. So when we solve it recursively the recursive solution will get subproblems in correct order. 


*/
