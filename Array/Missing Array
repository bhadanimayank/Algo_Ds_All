Problem Description
----------------------------------------------------------------------------------------------------------------------

Akash bought a sequence [1, 2, ..., N-1, N] but unfortunately he had jumbled this sequence.
You are asked to help him and the only clue you have for its order is an array representing whether each number is larger or smaller than all the previous elements.

For example, given ['.', '+', '+', '-', '+'], you should return [2, 3, 4, 1, 5].

'+' at ith index denotes that the ith number is larger than all the number indexed less than i.
'-' at ith index denotes that the ith number is smaller than all the number indexed less than i.
Given this information, return an array denoting the original sequence.



Problem Constraints
1 <= N <= 105

A[i] = '.' or '+' or '-'

Only A[0] = '.'



Input Format
First and only argument is a character array A of size N denoting the order of the original array.



Output Format
Return an integer array of size N denoting the original sequence.



Example Input
Input 1:

 A = ['.', '-', '-', '+', '+']
Input 2:

 A = ['.', '-', '+', '-']


Example Output
Output 1:

 [3, 2, 1, 4, 5]
Output 2:

 [3, 2, 4, 1]


Example Explanation
Explanation 1:

 Output array is built according to the given order denoted by character array.
 
 
 
Solution: // Mayank Bhadani - O(n)
---------------------------------------------------------------------------------------------------------------------------------------------
public class Solution {
    public int[] solve(char[] A) {
        
        int len = A.length;
        int res[] = new int[len];
        
        int min = 1;
        int max = len;
        
        for( int i = len - 1 ; i >= 0 ; --i )
        {
            if( A[i] == '+' )
            {
                res[i] = max;
                --max;
            }
            
            if( A[i] == '-' )
            {
                res[i] = min;
                ++min;
            }
            
            if( A[i] == '.' )
            {
                res[i] = max > min ? min : max;
            }
        }
        
        return res;
    }
}
