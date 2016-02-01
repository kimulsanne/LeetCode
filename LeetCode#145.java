//LeetCode#145: Binary Tree Postorder Traversal
//Runtime: 1ms
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) 
            return result;
        postTraversal(root);
        return result;
    }
    public void postTraversal(TreeNode node) {
        if (node.left != null) {
            postTraversal(node.left);
        }
        if (node.right != null) {
            postTraversal(node.right);
        }
        result.add(node.val);        
    }
}