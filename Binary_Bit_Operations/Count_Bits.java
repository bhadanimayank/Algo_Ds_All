// https://leetcode.com/problems/number-of-1-bits/description/

/*


Code


Testcase
Testcase
Test Result
191. Number of 1 Bits
Solved
Easy
Topics
Companies
Given a positive integer n, write a function that returns the number of 
set bits
 in its binary representation (also known as the Hamming weight).

 

Example 1:

Input: n = 11

Output: 3

Explanation:

The input binary string 1011 has a total of three set bits.

Example 2:

Input: n = 128

Output: 1

Explanation:

The input binary string 10000000 has a total of one set bit.

Example 3:

Input: n = 2147483645

Output: 30

Explanation:

The input binary string 1111111111111111111111111111101 has a total of thirty set bits.

 

Constraints:

1 <= n <= 231 - 1
 

Follow up: If this function is called many times, how would you optimize it?

*/

class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        while(n != 0)
        {
            if((n & 1) == 1)
            {
                ++count;
            }
            n = n >> 1;
        }

        return count;
    }
}

/* Notes

So we apply uniary binary and opeartor to the number and bit 1. So the 1 will be and with the last bit of number.
If the result is 1, then the last bit of number was 1. If we get 1, we increase the count.

Then we left shift the number by one place, so second last bit from the left becomes the last bit.
Then we continue the loop.

*/