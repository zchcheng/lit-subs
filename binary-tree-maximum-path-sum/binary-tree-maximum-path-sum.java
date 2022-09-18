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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        max = root.val;
        helper(root);
        return max;
    }
    
    int helper(TreeNode root) {
        if (root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int val = Math.max(0, left) + root.val + Math.max(0, right);
        max = Math.max(val, max);
        
        return Math.max(0, Math.max(root.val + Math.max(0, left), root.val + Math.max(0, right)));
    }
}