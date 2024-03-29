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
    public boolean isValidBST(TreeNode root) {
        return validateHelper(root, null, null);
    }
    
    boolean validateHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        
        return validateHelper(root.left, min, (max == null)? root.val : Math.min(root.val, max)) &&
            validateHelper(root.right, (min == null)? root.val : Math.max(root.val, min), max);
    }
}