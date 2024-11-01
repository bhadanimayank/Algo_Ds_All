// https://leetcode.com/problems/invert-binary-tree/description/

/*

226. Invert Binary Tree
Solved
Easy
Topics
Companies
Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Seen this question in a real interview before?
1/5
Yes
No
Accepted
2.3M
Submissions
3M
Acceptance Rate
78.1%

*/


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

// Java

class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null)
            return root;

        if(root.left != null)
            invertTree(root.left);

        if(root.right != null)
            invertTree(root.right);

        TreeNode mid = root.left;
        root.left = root.right;
        root.right = mid;
        
        return root;  

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
    public TreeNode InvertTree(TreeNode root) {
        
        if(root == null)
            return null;

        InvertTree(root.left);
        InvertTree(root.right);

        TreeNode mid = root.left;
        root.left = root.right;
        root.right = mid;

        return root;        
    }
}