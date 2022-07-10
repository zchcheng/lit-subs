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
    private int res = 0;
    
    public int maxPathSum(TreeNode root) {
        res = root.val;
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        int lm = (root.left == null)? 0 : helper(root.left);
        int rm = (root.right == null)? 0 : helper(root.right);
        
        res = Math.max(
            res,
            Math.max(root.val, 
                     Math.max(root.val + lm,
                             Math.max(root.val + rm, root.val + lm + rm))
            )
        );
        
        return Math.max(0, Math.max(root.val + lm, root.val + rm));
    }
}