// https://leetcode.com/problems/maximum-product-subarray/description/
// https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/

/*

152. Maximum Product Subarray
Solved
Medium
Topics
Companies
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.

*/

class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;

        int prefix = 1;
        int suffix = 1;

        int maxProd = Integer.MIN_VALUE; 

        for(int i = 0; i < n; i++)
        {
            if(prefix == 0)
                prefix = 1;

            if(suffix == 0)
                suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];

            maxProd = Math.max(maxProd, prefix);
            maxProd = Math.max(maxProd, suffix);
        }

        return maxProd;
    }
}


/*

So Consider and array [1, 2, 0, 3, 4, 5, -1, 120, -10 ]
Now to get contigous greater product, we need to reset to 1 when we reach a 0 as product then will become 0 


But why we need to take pass from both side. Take Example [3, -1, 4]
Here 4 will be the answer, but if you ony take from left side answer be either [3], [-3] or [-12], but we will get greater when we will pass from right side.

So we need to check at every step


*/