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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        
        while(root != null && root.val != p.val) {
            if (root.val < p.val) {
                root = root.right;
                continue;
            }
            
            prev = root;
            root = root.left;
        }
        
        if (root == null) return null;
        
        TreeNode next = root.right;
        if (next == null) return prev;
        
        while(next.left != null) next = next.left;
        
        return next;
    }
}