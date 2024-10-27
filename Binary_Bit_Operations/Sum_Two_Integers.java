// https://leetcode.com/problems/sum-of-two-integers/description/


/*

371. Sum of Two Integers
Solved
Medium
Topics
Companies
Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
 

Constraints:

-1000 <= a, b <= 1000


*/

// C#

public class Solution {
    public int GetSum(int a, int b) {
        
        int sum = a;
        while(b != 0)
        {
            int carry = (sum & b) << 1;
            sum = sum ^ b;
            b = carry; 
        }

        return sum;
    }
}

// Java

class Solution {
    public int getSum(int a, int b) {
        
        while(b != 0)
        {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }

        return a;
    }
}

/* Notes

(a & b) << 1 returns only the carry if the a and b are summed

a = a ^ b adds a and b and store it in a

Do it while b is not equal to 0

*/