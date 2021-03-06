//LeetCode#111: Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
    if(root == null) return 0;
    int depth = 1;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    while(!q.isEmpty()){
        int size = q.size();
        // for each level
        for(int i=0;i<size;i++){
            TreeNode node = q.poll();
            if(node.left == null && node.right == null){
                return depth;
            }
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
        }
        depth++;
    }
    return depth;
    }
    public class Node {
        TreeNode treeNode;
        int depth;
        Node(TreeNode node, int depth) {
            this.treeNode = node;
            this.depth = depth;
        }
    }
}