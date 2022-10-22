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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        while(root != null) {
            TreeNode prev = findPrev(root);
            if (prev != null) prev.right = root;
            
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                TreeNode next = root.left;
                root.left = null;
                root = next;
            }
        }
        
        return res;
    }
    
    TreeNode findPrev(TreeNode current) {
        TreeNode p = current.left;
        
        while(p != null && p.right != null) p = p.right;
        
        return p;
    }
}