/* Problem - https://www.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-all-lcs-sequences

You are given two strings s and t. Now your task is to print all longest common sub-sequences in lexicographical order.

Example 1:

Input: s = abaaa, t = baabaca
Output: aaaa abaa baaa
Example 2:

Input: s = aaa, t = a
Output: a
Your Task:
You do not need to read or print anything. Your task is to complete the function all_longest_common_subsequences() which takes string a and b as first and second parameter respectively and returns a list of strings which contains all possible longest common subsequences in lexicographical order.
 

Expected Time Complexity: O(n4)
Expected Space Complexity: O(K * n) where K is a constant less than n.

*/

class Solution
{
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        // Code here
        int m = s.length();
        int n = t.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        // This for loop will fill the dp and will find the length of longest subsequence
        for( int i = 0; i <= m; i++ )
        {
            for( int j = 0; j <= n; j++ )
            {
                if( i == 0 || j == 0 )
                {
                    dp[i][j] = 0;
                }
                else if( s.charAt(i - 1) == t.charAt(j - 1) )
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max( dp[i - 1][j], dp[i][j - 1] );
                }
            }
        }
        
        // Each element in this 2-D array will contain a Set of Strngs
        Object[][] arraySet = new Object[m + 1][n + 1];
        
        List<String> ans = new ArrayList<>();
        
        Set<String> set = solve(dp, s, t, m, n, arraySet);
        
        for(String str: set)
        {
            ans.add(str);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
    
    public Set<String> solve(int[][] dp, String s, String t, int m, int n, Object[][] arraySet)
    {
        Set<String> set = new HashSet<>();
        
        if(arraySet[m][n] != null)
            return (Set<String>)arraySet[m][n];
        
        if( m == 0 || n == 0 )
        {
            set.add("");
            arraySet[m][n] = set;
            return set;
        }
        
        if( s.charAt(m - 1) == t.charAt(n - 1) )
        {
            Set<String> curSet = solve(dp, s, t, m - 1, n - 1, arraySet);
            
            for(String str: curSet)
            {
                set.add(str + s.charAt(m - 1));
            }
        }
        else
        {
            if( dp[m - 1][n] >= dp[m][n - 1] )
            {
                set = solve(dp, s, t, m - 1, n, arraySet);
            }
            
            if(dp[m - 1][n] <= dp[m][n - 1])
            {
                Set<String> curSet = solve(dp, s, t, m, n - 1, arraySet);
                set.addAll(curSet);
            }
        }
        
        arraySet[m][n] = set;
        return set;
    }
}