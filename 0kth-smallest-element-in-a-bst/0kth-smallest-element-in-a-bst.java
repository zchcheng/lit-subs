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
    TreeNode res = null;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res.val;
    }

    int helper(TreeNode root, int k) {
        if (root == null)
            return 0;

        int cl = helper(root.left, k);
        if (cl >= k)
            return cl;

        if (cl + 1 == k) {
            res = root;
            return k;
        }

        int cr = helper(root.right, k - cl - 1);

        return cl + cr + 1;
    }
}