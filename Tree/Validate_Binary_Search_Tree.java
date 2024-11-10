// https://leetcode.com/problems/validate-binary-search-tree/description/

/*

98. Validate Binary Search Tree
Solved
Medium
Topics
Companies
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

*/

// Java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return isValidBST(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    }

    public boolean isValidBST(long min, TreeNode root, long max)
    {
        if(root == null)
        {
            return true;
        }

        if(root.val % (int)1e9+7 >= max || root.val % (int)1e9+7 <= min)
        {
            return false;
        }

        return isValidBST(min, root.left, root.val % (int)1e9+7) && isValidBST(root.val % (int)1e9+7, root.right, max);
    }
}

/* Notes

                                |
                                10 (-∞ , +∞)
                                |
               --------------------------------------
               |                                    |
               8   (-∞ , 10)                        13   (10 , +∞)
               |                                    |
       ----------------                    -----------------
       |              |                    |               |
       7              9                    12              14
   (-∞ , 8)        (8 , 10)            (10 , 13)        (13 , +∞)


In BST, left side values will be lesser than node value and right side values will be greater than node value.
The same will be applicable for the whole subtree not only for child node.

So, each element will have a lower limit and higher limit for the values.
So, itertaively we will set the limits recursively. 

*/