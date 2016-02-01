//LeetCode#99: Recover Binary Search Tree
//Runtime: 52ms
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *first = NULL;
    TreeNode *second = NULL;
    TreeNode *previous = NULL;

    void recoverTree(TreeNode *root) {
        if (!root) return;
        previous = new TreeNode(INT_MIN);

        morris_inorder(root);
        int t = first->val;
        first->val = second->val;
        second->val = t;
    }

    void morris_inorder(TreeNode *root) {
        TreeNode *cur = root, *pre = NULL;

        while (cur) {
            if (cur->left == NULL) {
                if (cur->val <= previous->val && !first) first = previous;
                if (cur->val <= previous->val && first) second = cur;
                previous = cur;
                cur = cur->right;
            }
            else {
                // find the predecessor
                pre = cur->left;
                while (pre->right && pre->right != cur)
                    pre = pre->right;

                if (pre->right == NULL) {
                    // set the backtrace link
                    pre->right = cur;
                    cur = cur->left;
                }
                else {
                    if (cur->val <= previous->val && !first) first = previous;
                    if (cur->val <= previous->val && first) second = cur;
                    previous = cur;
                    pre->right = NULL;
                    cur = cur->right;
                }
            }
        }
    }

};