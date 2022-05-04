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
    int res = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }
    
    int helper(TreeNode root) {
        if (root == null) return 0;
        
        int dl = helper(root.left);
        int dr = helper(root.right);
        
        res = Math.max(res, dl + dr);
        
        return Math.max(dl, dr) + 1;
    }
}