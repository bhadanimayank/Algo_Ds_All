// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

/*

230. Kth Smallest Element in a BST
Solved
Medium
Topics
Companies
Hint
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

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
 **/
 
class Solution {

    List<Integer> lst = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {    
        this.traversal(root);
        return lst.get(k - 1);
    }

    public TreeNode traversal(TreeNode root)
    {
        if(root != null)
        {
            tarversal(root.left);
            lst.add(root.val);
            traversal(root.right);
        }

        return null;
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

    List<int> list = new List<int>();

    public int KthSmallest(TreeNode root, int k) {
        
        traversal(root);
        return list.ElementAt(k - 1);
    }

    public void traversal(TreeNode root)
    {
        if(root.left != null)
            traversal(root.left);

        list.Add(root.val);

        if(root.right != null)
            traversal(root.right);
    }
}

/* Notes

Simple traversing the tree, first going through the let nodes, at last itreaton it will go to lease number.
then going each right side, it gets a larger element.

So you get increasing order element, put the elements in the list. So, you can get the element at particular position. 

*/