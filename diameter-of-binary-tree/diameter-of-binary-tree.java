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
    int result = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return result;
    }
    
    int helper(TreeNode root) {
        int l = (root.left == null)? 0 : helper(root.left);
        int r = (root.right == null)? 0 : helper(root.right);
        
        result = Math.max(result, l + r);
        
        return Math.max(l, r) + 1;
    }
}