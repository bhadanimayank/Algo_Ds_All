// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

/*

124. Binary Tree Maximum Path Sum
Solved
Hard
Topics
Companies
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000

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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }

    public int solve(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));

        max = Math.max(max, left + root.val + right);

        return root.val + Math.max(left, right);
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

    int max = int.MinValue;

    public int MaxPathSum(TreeNode root) {
        solve(root);
        return max;
    }

    public int solve(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int left = Math.Max(0, solve(root.left));
        int right = Math.Max(0, solve(root.right));

        max = Math.Max(max, left + root.val + right);

        return root.val + Math.Max(left, right);
    }
}


/* Notes

So every node is the central part of the max path, or the max path passes through it

So if it's the central node, we update the max value and calculate max by adding left path value, current node value and right path value

If the path passes through it, we need to check if the left part have the max part or the right path have the max path.
Whoever, have the max path, we add the root valeu to it and return the total value to recursion.

*/