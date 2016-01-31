//LeetCode#101: Symmetric Tree
//Runtiome: 1ms
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
    public boolean isSymmetric(TreeNode root) {
        if (root != null)
            return isSymmetric(root.left, root.right);
        else return true;
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null) 
            return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        else return left == null && right == null;
        
    }
}