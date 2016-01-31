//LeetCode#100: Same Tree
//Runtiome: 1ms
//DFS version
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null)  {
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else return p == null && q == null;
    }
}


//Runtime: 1ms
//BFS version
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)  {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null))  {
            return false;
        }
        Queue<TreeNode> listP = new LinkedList<TreeNode>();
        Queue<TreeNode> listQ = new LinkedList<TreeNode>();
        listP.offer(p);
        listQ.offer(q);
        while(!listP.isEmpty() && !listQ.isEmpty()){
            int size = listP.size();
            // for each level
            for(int i = 0; i < size; i++){
                TreeNode nodeQ = listQ.poll();
                TreeNode nodeP = listP.poll();
                if(nodeQ.val != nodeP.val){
                    return false;
                }
                if (nodeP.left == null && nodeQ.left == null){
                }
                else if (nodeP.left != null && nodeQ.left != null){
                    listP.offer(nodeP.left);
                    listQ.offer(nodeQ.left);
                }
                else {
                    return false;
                }       
                
                if (nodeP.right == null && nodeQ.right == null){
                }
                else if (nodeP.right != null && nodeQ.right != null){
                    listP.offer(nodeP.right);
                    listQ.offer(nodeQ.right);
                }              
                else {
                    return false;
                }                
            }
        }
        return true;
    }
}