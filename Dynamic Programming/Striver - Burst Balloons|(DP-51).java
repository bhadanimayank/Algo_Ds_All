/* Problem - https://leetcode.com/problems/burst-balloons/description/

https://takeuforward.org/data-structure/burst-balloons-partition-dp-dp-51/

312. Burst Balloons
Solved
Hard
Topics
Companies
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100

*/

class Solution {
    public int maxCoins(int[] nums) {

        int m = nums.length;
        int n = m + 2;

        int[] cnums = new int[n];

        cnums[0] = 1;
        cnums[n - 1] = 1;

        int[][] dp = new int[n][n];

        for(int[] row: dp)
            Arrays.fill(row, -1);

        for(int i = 0; i < m; i++)
        {
            cnums[i + 1] = nums[i];
        }
        
        return solve(1, n - 2, cnums, dp);
    }

    public int solve(int i, int j, int[] cnums, int[][] dp)
    {
        if(i > j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int max = Integer.MIN_VALUE;

        for( int k = i; k <= j; k++ )
        {
            int cost = cnums[i - 1] * cnums[k] * cnums[j + 1]
                     + solve(i, k - 1, cnums, dp)
                     + solve(k + 1, j, cnums, dp);

            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }
}

/* Notes

Added 1 at the start and end of the array to include the border cases.

Now how the logic works, suppose below is the baloon array

[1, b1, b2, b3, b4, b5, 1]
 0  1   2   3   4   5   6

* now suppose b3 gets burst, bow we have two array

[1, b1, b2] amd [b4, b5, 1]

again suppose b1 and b5 nursts, now we have

[1], [b2], [b4], [1]

now again [b2] amd [b4] also gets burst.

Now o to point * above, when we choose b3 to get burst and it's top down approach, so all baloons betweeen 1 and b3 will gets burst also all baloons b3 and 1 will gets burst on both side
So cost of b3 is 1 * b3 * 1

So, to start we are starting from index 1 and index 5, so index 0 and index 6 will be covered simplyifying calculation of border cases

***** This is important to include border cases to simplify the solution

*/