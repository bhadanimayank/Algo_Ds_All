// https://leetcode.com/problems/maximum-depth-of-binary-tree/

// https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/

/*


Code
Testcase
Testcase
Test Result
104. Maximum Depth of Binary Tree
Solved
Easy
Topics
Companies
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

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
    public int maxDepth(TreeNode root) {
        
        return checkDepth(root);
    }

    public int checkDepth(TreeNode root) {
        
        if(root == null)
            return 0;

        int leftDepth = checkDepth(root.left);
        int rightDepth = checkDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}

// C#

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int MaxDepth(TreeNode root) {
        
        if(root == null)
            return 0;

        return 1 + Math.Max(MaxDepth(root.left), MaxDepth(root.right));
    }
}
