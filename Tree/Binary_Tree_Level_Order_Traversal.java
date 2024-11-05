// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// https://takeuforward.org/data-structure/level-order-traversal-of-a-binary-tree/

/*


Code


Testcase
Testcase
Test Result
102. Binary Tree Level Order Traversal
Solved
Medium
Topics
Companies
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> finalAns = new ArrayList<List<Integer>>();

        if(root == null)
            return finalAns;

        q.add(root);

        List<Integer> sublist;

        while(!q.isEmpty())
        {
            int levels = q.size();
            sublist = new ArrayList<Integer>();

            for(int i = 0; i < levels; i++)
            {
                TreeNode current = q.remove();

                if(current.left != null)
                    q.add(current.left);

                if(current.right != null)
                    q.add(current.right);

                sublist.add(current.val);
            }

            finalAns.add(sublist);
        }

        return finalAns;
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
    public IList<IList<int>> LevelOrder(TreeNode root) {
        
        IList<IList<int>> ans = new List<IList<int>>();

        Queue<TreeNode> queue = new Queue<TreeNode>();

        if(root == null)
            return ans;

        queue.Enqueue(root);

        List<int> sub;

        while(queue.Count != 0)
        {
            int level = queue.Count;
            sub = new List<int>();

            for(int i = 0; i < level; i++)
            {
                TreeNode temp = queue.Dequeue();

                if(temp.left != null)
                    queue.Enqueue(temp.left);

                if(temp.right != null)
                    queue.Enqueue(temp.right);

                sub.Add(temp.val);
            }

            ans.Add(sub);
        }

        return ans;
    }
}


/* Notes

1) So we put the root node in a queue. 

2) We check the count of queue, we ran a loop till the count

3) with each iteration, we dequeue, till we reach the set count. 

4) For each dequeu above we put the left and right child elemnt in the queue. After putting the child, we insert the dequeued element in the sublist 

5) So when the iteration runs till the last set count, we have next level of elemnets in the queue. Also we then add the sublist to the final list of lists

6) We then repeat from step 2

*/