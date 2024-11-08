// https://leetcode.com/problems/subtree-of-another-tree/description/

// https://takeuforward.org/data-structure/subtree-of-another-tree/

/*

572. Subtree of Another Tree
Solved
Easy
Topics
Companies
Hint
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104


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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null || subRoot == null)
            return root == null && subRoot == null;

        if(root.val == subRoot.val)
            return checkCongurance(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        else
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean checkCongurance(TreeNode root, TreeNode subRoot) {

        if(root == null || subRoot == null)
            return root == null && subRoot == null;

        if(root.val == subRoot.val)
            return checkCongurance(root.left, subRoot.left) && checkCongurance(root.right, subRoot.right);
        else
            return false;
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
    public bool IsSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null || subRoot == null)
        {
            return root == null && subRoot == null;
        }

        if(root.val == subRoot.val)
        {
            return checkCongurance(root, subRoot) || IsSubtree(root.left, subRoot) || IsSubtree(root.right, subRoot);
        }
        else
        {
            return IsSubtree(root.left, subRoot) || IsSubtree(root.right, subRoot);
        }
    }

    public bool checkCongurance(TreeNode root, TreeNode subRoot)
    {
        if(root == null || subRoot == null)
        {
            return root == null && subRoot == null;
        }

        if(root.val == subRoot.val)
        {
            return checkCongurance(root.left, subRoot.left) && checkCongurance(root.right, subRoot.right);
        }
        else
        {
            return false;
        }
    }
}


// Notes

/*

-> First the description over the leetcode images are not correct as multiple nodes in the tree can have same value.

-> So what we are doing in the function IsSubtree is to iterate over the main tree going through left and right nodes to check if the subtrees root value matches with the any of the node value of the main tree.

-> If the value matches, we send the node values to the checkCongurance function. Irrespective of the Congurance check we keep checking the left and right subtree values due to first point.

-> In the Congurance check function we are just checking if all the nodes matches.

// Important Construct to only return true if both the nodes are null or false in any of the other cases

        if(root == null || subRoot == null)
        {
            return root == null && subRoot == null;
        }

*/