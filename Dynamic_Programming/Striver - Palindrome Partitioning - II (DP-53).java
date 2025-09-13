/* Problem - https://leetcode.com/problems/palindrome-partitioning-ii/description/

https://takeuforward.org/data-structure/palindrome-partitioning-ii-front-partition-dp-53/

*/

class Solution {
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, n, s, dp) - 1;
    }
    
    public int solve(int ind, int n, String s, int[] dp)
    {
        if( ind == n )
            return 0;

        if( dp[ind] != -1 )
            return dp[ind];

        int min = Integer.MAX_VALUE;

        for( int k = ind; k < n; i++ )
        {
            if(isPalindrome(ind, k, s))
            {
                int nop = 1 + solve(k + 1, n, s, dp);

                min = Math.min(min, nop);
            }
        }

        return dp[ind] = min;
    }

    public boolean isPalindrome(int start, int end, String s)
    {
        while( start <= end )
        {
            if( s.charAt(start) != s.charAt(end) )
            {
                return false;
            }
            ++start;
            --end;
        }

        return true;
    }
}

/* Notes

Here we are taking a set inside a for loop starting from k = 0 to k < n and checking is that substring is palindrome and sending rest of the part to recursively check the 
Same thing

*/
