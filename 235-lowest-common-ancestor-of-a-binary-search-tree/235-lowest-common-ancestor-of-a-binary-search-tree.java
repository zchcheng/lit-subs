/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        
        while(root != null) {
            if (p.val == root.val || q.val == root.val) {
                return root;
            }
            
            if (p.val < root.val && q.val < root.val) {
                result = root;
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                result = root;
                root = root.right;
            } else {
                return root;
            }
        }
        
        return result;
    }
}